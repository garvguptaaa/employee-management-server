package com.example.employeemanagement.dto;

import com.example.employeemanagement.utility.Enumeration.Status;
import com.example.employeemanagement.utility.Enumeration.UserType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long roleId;
    private String mobile;
    private Status status;
    private UserType userType;
    private String address;
    private String position;
}
