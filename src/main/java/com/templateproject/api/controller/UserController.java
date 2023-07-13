package com.templateproject.api.controller;

import com.templateproject.api.entity.User;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Find users", description = "Find all users")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/users/")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Find user", description = "Find a user")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("user/{id}")
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(String email, String password) {
        return userService.login(email, password);
    }

}