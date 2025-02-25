package com.example.employeemanagement.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.example.employeemanagement.utility.Enumeration.Status;
import com.example.employeemanagement.utility.Enumeration.UserType;

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
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Long roleId;

    @CreatedDate
    private Date creatdDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.USER;
}
