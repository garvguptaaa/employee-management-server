package com.example.employeemanagement.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private Long id;
    private String name;
    private List<RoleAccessDto> roleAccess;

}
