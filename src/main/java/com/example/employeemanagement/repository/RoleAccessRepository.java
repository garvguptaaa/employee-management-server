package com.example.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.model.RoleAccessModel;

@Repository
public interface RoleAccessRepository extends JpaRepository<RoleAccessModel, Long> {

    List<RoleAccessModel> findByRoleId(Long id);
}
