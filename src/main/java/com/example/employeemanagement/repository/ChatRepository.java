package com.example.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.model.ChatModel;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, Long> {

    List<ChatModel> findByFromIdAndToId(Long fromId, Long toId);

    List<ChatModel> findByToIdAndFromId(Long fromId, Long toId);

}
