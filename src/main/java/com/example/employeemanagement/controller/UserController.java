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

import com.example.employeemanagement.dto.UserDto;
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

    @GetMapping(value = "/all/list")
    public ResponseEntity<List<UserModel>> getAllList() {
        List<UserModel> list = userService.getAllList();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserModel user) {
        Optional<UserModel> isAuthenticated = userService.authenticate(user.getEmail(), user.getPassword());
        if (isAuthenticated.isPresent()) {
            UserDto userDto = new UserDto();
            userDto.setId(isAuthenticated.get().getId());
            userDto.setFirstName(isAuthenticated.get().getFirstName());
            userDto.setLastName(isAuthenticated.get().getLastName());
            userDto.setEmail(isAuthenticated.get().getEmail());
            userDto.setRoleId(isAuthenticated.get().getRoleId());
            userDto.setMobile(isAuthenticated.get().getMobile());
            userDto.setStatus(isAuthenticated.get().getStatus());
            userDto.setUserType(isAuthenticated.get().getUserType());
            userDto.setAddress(isAuthenticated.get().getAddress());
            userDto.setPosition(isAuthenticated.get().getPosition());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
