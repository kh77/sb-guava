package com.sm.controller;

import com.sm.dto.User;
import com.sm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User findById(@RequestBody User user) {
        return userService.create(user);
    }


}
