package com.raven.ecommerce.controller;

import com.raven.ecommerce.Exception.UserException;
import com.raven.ecommerce.Repo.UserRepository;
import com.raven.ecommerce.Response.UserResponse;
import com.raven.ecommerce.Entity.UserEntity;
import com.raven.ecommerce.jwt.JwtProvider;
import com.raven.ecommerce.services.UserService;
import com.raven.ecommerce.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    private JwtProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;
    private UserServiceImpl customUserService;
    private UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    public UserController( AuthenticationManager authenticationManager, JwtProvider jwtTokenProvider, UserService userService, PasswordEncoder passwordEncoder, UserServiceImpl customUserService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.customUserService = customUserService;
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Map<String, String> user) throws UserException {
        UserEntity existingUser = userService.findByUsername(user.get("username"));
        if (existingUser != null) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        UserEntity newUser = userService.save(user);
        System.out.println( newUser );
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
        Authentication authentication = authenticate(user.getUsername(), password);
        System.out.println("========|||=========== u" );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println("========|||=========== " + token);
        return UserResponse.responseBuilder("Login Successfully", HttpStatus.OK, token, user);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.status(HttpStatus.OK).body("Logged out successfully");
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserEntity> getUser(@PathVariable String username) throws UserException {
        UserEntity user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserService.loadUserByUsername( username );

        if (userDetails == null) {
            throw new BadCredentialsException( "Invalid Username ... " );
        }

        if (!passwordEncoder.matches( password, userDetails.getPassword( ) )) {
            throw new BadCredentialsException( "Invalid Password ... " );
        }

        return new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities( ) );
    }
}
