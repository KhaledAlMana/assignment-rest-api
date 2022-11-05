package com.assignment.restapi.controllers;

import java.util.Map;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;
import lombok.experimental.Accessors;

import com.assignment.restapi.services.Impl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/tomato")
    public String index() {
        return "Welcome Tomato";
    }

    @GetMapping("/")
    public Object getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/me")
    public Info getInfo(OAuth2AuthenticationToken authentication) {
        return new Info()
                .setApplication("GitHub")
                .setPrincipal(authentication.getPrincipal().getAttributes());
    }

    @Data
    @Accessors(chain = true)
    private static class Info {
        private String application;
        private Map<String, Object> principal;
    }
}
