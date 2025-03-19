package com.example.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.employeemanagement.dto.ChatDto;
import com.example.employeemanagement.dto.RoleDto;
import com.example.employeemanagement.model.ChatModel;
import com.example.employeemanagement.model.RoleModel;
import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.repository.ChatRepository;
import com.example.employeemanagement.response.ApiResponse;

@Service
public class ChatService {

    private ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public ApiResponse createAndUpdateUser(@RequestBody ChatDto chat) {
        ChatModel chatModel = null;
        if (chat.getId() != null) {
            chatModel = chatRepository.findById(chat.getId()).orElse(null);
        } else {
            chatModel = new ChatModel();
        }
        chatModel.setFromId(chat.getFromId());
        chatModel.setToId(chat.getToId());
        chatModel.setMessage(chat.getMessage());
        chatRepository.save(chatModel);
        return new ApiResponse(chatModel.getId(), "Chat send successfully");
    }

    public List<ChatDto> getAllList(@RequestBody ChatDto chat) {
        List<ChatDto> response = new ArrayList<>();
        List<ChatModel> list = chatRepository.findAll();
        if (list != null && !list.isEmpty()) {
            for (ChatModel chatModel : list) {
                ChatDto userDto = new ChatDto();
                userDto.setId(chatModel.getId());
                userDto.setFromId(chatModel.getFromId());
                response.add(userDto);
            }
        }
        return response;
    }

}
