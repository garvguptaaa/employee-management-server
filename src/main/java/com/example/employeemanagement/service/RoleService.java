package com.example.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.RoleAccessDto;
import com.example.employeemanagement.dto.RoleDto;
import com.example.employeemanagement.model.RoleAccessModel;
import com.example.employeemanagement.model.RoleModel;
import com.example.employeemanagement.repository.RoleAccessRepository;
import com.example.employeemanagement.repository.RoleRepository;
import com.example.employeemanagement.response.ApiResponse;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    private RoleAccessRepository roleAccessRepository;

    public RoleService(RoleRepository roleRepository, RoleAccessRepository roleAccessRepository) {
        this.roleRepository = roleRepository;
        this.roleAccessRepository = roleAccessRepository;
    }

    public ApiResponse addMenuRoleAcces(RoleDto role) {
        RoleModel roleModel = null;
        if (role.getId() != null) {
            roleModel = roleRepository.findById(role.getId()).orElse(null);
        } else {
            roleModel = new RoleModel();
        }
        roleModel.setName(role.getName());
        roleRepository.save(roleModel);

        for (RoleAccessDto roleAccess : role.getRoleAccess()) {
            RoleAccessModel roleAccessModel = null;
            if (roleAccess.getId() != null) {
                roleAccessModel = roleAccessRepository.findById(roleAccess.getId()).get();
            } else {
                roleAccessModel = new RoleAccessModel();
            }
            roleAccessModel.setMenu(roleAccess.getMenu());
            roleAccessModel.setMenuCode(roleAccess.getMenuCode());
            roleAccessModel.setIsView(roleAccess.getIsView());
            roleAccessModel.setIsAdd(roleAccess.getIsAdd());
            roleAccessModel.setIsEdit(roleAccess.getIsEdit());
            roleAccessModel.setIsDelete(roleAccess.getIsDelete());
            roleAccessModel.setRoleId(roleModel.getId());
            roleAccessRepository.save(roleAccessModel);
        }

        return new ApiResponse(null, "Added Successfully");
    }

    public RoleDto getDetails(Long id) {
        RoleModel roleModel = roleRepository.findById(id).orElse(null);
        if (roleModel == null) {
            throw new RuntimeException("Role not found");
        }
        RoleDto roleDto = new RoleDto();
        roleDto.setId(roleModel.getId());
        roleDto.setName(roleModel.getName());

        List<RoleAccessDto> roleAccess = new ArrayList<>();
        List<RoleAccessModel> list = roleAccessRepository.findByRoleId(roleModel.getId());
        for (RoleAccessModel roleAccessModel : list) {
            RoleAccessDto roleAccessDto = new RoleAccessDto();
            roleAccessDto.setId(roleAccessModel.getId());
            roleAccessDto.setMenu(roleAccessModel.getMenu());
            roleAccessDto.setMenuCode(roleAccessModel.getMenuCode());
            roleAccessDto.setIsView(roleAccessModel.getIsView());
            roleAccessDto.setIsAdd(roleAccessModel.getIsAdd());
            roleAccessDto.setIsEdit(roleAccessModel.getIsEdit());
            roleAccessDto.setIsDelete(roleAccessModel.getIsDelete());
            roleAccess.add(roleAccessDto);
        }
        return roleDto;
    }

    public List<RoleDto> getAllList() {
        List<RoleDto> response = new ArrayList<>();
        List<RoleModel> list = roleRepository.findAll();
        if (list != null && !list.isEmpty()) {
            for (RoleModel roleModel : list) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(roleModel.getId());
                roleDto.setName(roleModel.getName());
                response.add(roleDto);
            }
        }
        return response;
    }

}
