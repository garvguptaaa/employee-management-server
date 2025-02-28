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
    private String menuCode;
    private Long roleId;
    private Boolean isView;
    private Boolean isAdd;
    private Boolean isEdit;
    private Boolean isDelete;
    private Date createDate;
    private Date updateDate;

}
