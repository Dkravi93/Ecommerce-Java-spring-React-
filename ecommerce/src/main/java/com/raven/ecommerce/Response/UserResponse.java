package com.raven.ecommerce.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class UserResponse {
    public static ResponseEntity <Object> responseBuilder(
            String message, HttpStatus httpStatus, String token, Object resObject
    ){
            Map <String, Object> response = new HashMap <>();
            response.put("message", message);
            response.put("httpStatus", httpStatus);
            response.put("token", token);
            response.put("data", resObject);

            return new ResponseEntity<>(response, httpStatus);

    }
}
