package com.example.employeemanagement.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        chatModel.setCreatdDate(new Date());
        chatRepository.save(chatModel);
        return new ApiResponse(chatModel.getId(), "Chat send successfully");
    }

    public List<ChatDto> getAllList(Long fromId, Long toId) {
        List<ChatDto> response = new ArrayList<>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT id, from_id, to_id, message, creatd_date FROM user_chats WHERE (from_id = '" + fromId
                        + "' AND to_id = '" + toId + "') OR (from_id = '" + toId + "' AND to_id = '" + fromId + "')"
                        + " ORDER BY creatd_date ASC");
        response= this.jdbcTemplate.query(
                query.toString(),
                new RowMapper<>() {
                    @Override
                    public ChatDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ChatDto chatDto = new ChatDto();
                        chatDto.setId(rs.getLong("id"));
                        chatDto.setFromId(rs.getLong("from_id"));
                        chatDto.setToId(rs.getLong("to_id"));
                        chatDto.setMessage(rs.getString("message"));
                        chatDto.setCreatdDate(rs.getTimestamp("creatd_date"));
                        return chatDto;
                    }
                });
       
        return response;
    }

}
