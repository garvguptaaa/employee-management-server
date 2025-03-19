package com.example.employeemanagement.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.dto.ChatDto;
import com.example.employeemanagement.dto.RoleDto;
import com.example.employeemanagement.model.ChatModel;
import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.response.ApiResponse;
import com.example.employeemanagement.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private ChatService ChatService;

    public ChatController(ChatService ChatService) {
        this.ChatService = ChatService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createAndUpdateUser(@RequestBody ChatDto chat) {
        return new ResponseEntity<>(ChatService.createAndUpdateUser(chat), new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/all/list")
    public List<ChatDto> getAllList(@RequestBody ChatDto chat) {
        return ChatService.getAllList(chat);
    }

}
