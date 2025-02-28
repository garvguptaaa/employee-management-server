package com.example.employeemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleAccessDto {

    private Long id;
    private String menu;
    private String menuCode;

    private Boolean isView;
    private Boolean isAdd;
    private Boolean isEdit;
    private Boolean isDelete;

}
