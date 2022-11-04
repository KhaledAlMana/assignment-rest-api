package com.assignment.restapi.controllers;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.restapi.services.Impl.UserServiceImpl;

@EnableAuthorizationServer
@SuppressWarnings("deprecation")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome Tomato";
    }

    @GetMapping("/all")
    public Object getAll() {
        return userService.getAllUsers();
    }

}
