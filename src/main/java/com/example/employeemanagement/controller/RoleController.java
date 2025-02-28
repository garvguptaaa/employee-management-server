package com.example.employeemanagement.controller;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.dto.RoleDto;
import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.response.ApiResponse;
import com.example.employeemanagement.service.RoleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addMenuRoleAcces(@RequestBody RoleDto role) {
        return new ResponseEntity<>(roleService.addMenuRoleAcces(role), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RoleDto getDetails(@PathVariable Long id) {
        return roleService.getDetails(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    @GetMapping("/all/list")
    public List<RoleDto> getAllList() {
        return roleService.getAllList();
    }

}
