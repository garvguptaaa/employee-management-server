package com.example.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping 
        public ResponseEntity<UserModel> createAndUpdateUser(@RequestBody UserModel user) {
            return new ResponseEntity<>(userService.createAndUpdateUser(user), new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserModel>> getAllUserList() {
        List<UserModel> list = userService.getAllUsers();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

}
