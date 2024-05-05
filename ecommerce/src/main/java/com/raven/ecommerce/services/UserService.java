package com.raven.ecommerce.services;

import com.raven.ecommerce.Entity.UserEntity;
import com.raven.ecommerce.Exception.UserException;
import java.util.Map;


public interface UserService {
    public UserEntity save(  Map <String, String> userData) throws UserException;
    public UserEntity findByUsername(String username) throws UserException;

    public UserEntity findUserById( Long userId) throws UserException;
}
