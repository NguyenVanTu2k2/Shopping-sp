package com.onlineshop.app.Services;


import com.onlineshop.app.Entities.Shopping_session;

import com.onlineshop.app.Entities.User;
import com.onlineshop.app.Repositories.SessionRepository;
import com.onlineshop.app.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public ResponseEntity<Object> signIn(String username, String password) {
        User user = userRepo.signIn(username, password);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.NOT_FOUND);
        }
    }
}