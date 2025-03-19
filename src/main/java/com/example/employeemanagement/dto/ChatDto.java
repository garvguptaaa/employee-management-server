package com.example.employeemanagement.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatDto {
    private Long id;
    private Long fromId;
    private Long toId;
    private String message;
    private Date creatdDate;
}
