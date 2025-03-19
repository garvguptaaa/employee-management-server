package com.example.employeemanagement.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.example.employeemanagement.utility.Enumeration.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_chats")
public class ChatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fromId;
    private Long toId;

    @Column(length = 1000)
    private String message;

    @CreatedDate
    private Date creatdDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

}
