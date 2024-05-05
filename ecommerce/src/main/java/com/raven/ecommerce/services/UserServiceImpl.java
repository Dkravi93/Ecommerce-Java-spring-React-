package com.raven.ecommerce.services;

import com.raven.ecommerce.Entity.UserEntity;
import com.raven.ecommerce.Exception.UserException;
import com.raven.ecommerce.Repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl( UserRepository userRepository, PasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity save(  Map <String, String> userData) throws UserException{
        String username = userData.get("username");
        String firstName = userData.get("firstname"); // Updated field name
        String lastName = userData.get("lastname"); // Updated field name
        String email = userData.get("email");
        String password = userData.get("password");
        String role = userData.get("role");
        String encodedPassword = passwordEncoder.encode(password);

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setRole(role);
        userRepository.save(user);
        return user;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity findUserById(Long userId) throws UserException {
        return null;
    }

    public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        System.out.println("========|||=========== "+user.getUsername());
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
