package com.example.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
