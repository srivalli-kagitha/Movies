package com.sri.movie_app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.movie_app.model.User;
import com.sri.movie_app.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) throws Exception{
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) throws Exception {
        return service.login(user.getEmail(), user.getPassword());
    }

    @GetMapping("/login")
    public String login() {
        return "Send a POST request with email and password to /login.";
    }
}
