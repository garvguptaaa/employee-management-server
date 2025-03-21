package com.example.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.utility.Enumeration.Status;
import com.example.employeemanagement.utility.Enumeration.UserType;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    List<UserModel> findByUserTypeAndStatus(UserType user, Status active);
    Optional<UserModel> findByEmail(String email);
    List<UserModel> findByStatus(Status active);

}
