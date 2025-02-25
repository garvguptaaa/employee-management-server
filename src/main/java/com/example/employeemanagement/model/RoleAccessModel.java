package com.example.employeemanagement.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "role_access")
public class RoleAccessModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menu;
    private String menu_Code;
    private Long roleId;
    private Boolean is_View;
    private Boolean is_Add;
    private Boolean is_Edit;
    private Boolean is_Delete;
    private Date createDate;
    private Date updateDate;

}
