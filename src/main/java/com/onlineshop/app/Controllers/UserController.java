package com.onlineshop.app.Controllers;


import com.onlineshop.app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("api/user/post/signIn/{username}/{password}")
    public ResponseEntity<Object> signIn(@PathVariable String username, @PathVariable String password) {
        return userService.signIn(username,password);

    }
}
