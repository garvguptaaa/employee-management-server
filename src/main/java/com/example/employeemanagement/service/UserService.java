package com.example.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.repository.UserRepository;
import com.example.employeemanagement.utility.Enumeration.Status;
import com.example.employeemanagement.utility.Enumeration.UserType;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createAndUpdateUser(UserModel user) {
        UserModel userModel = null;
        if (user.getId() != null) {
            userModel = userRepository.findById(user.getId()).orElse(null);
        } else {
            userModel = new UserModel();
        }

        // Write code here

        System.out.println("user.getFirstName() ::: " + user.getFirstName());
        System.out.println("user.getLastName() ::: " + user.getLastName());
        System.out.println("user.getEmail() ::: " + user.getEmail());
        System.out.println("user.getMobile() ::: " + user.getMobile());
        System.out.println("user.getStatus() ::: " + user.getStatus());
        System.out.println("user.getRoleId() ::: " + user.getRoleId());
        System.out.println("user.getUserType() ::: " + user.getUserType());
        System.out.println("user.getPassword() ::: " + user.getPassword());
        System.out.println("user.getAddress() ::: " + user.getAddress());
        System.out.println("user.getPosition() ::: " + user.getPosition());

        userModel.setEmail(user.getEmail());
        userModel.setMobile(user.getMobile());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setRoleId(user.getRoleId());
        userModel.setStatus(user.getStatus());
        userModel.setUserType(user.getUserType());
        userModel.setPassword(user.getPassword());
        userModel.setAddress(user.getAddress());
        userModel.setPosition(user.getPosition());

        return userRepository.save(userModel);
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findByUserTypeAndStatus(UserType.USER, Status.ACTIVE);
    }

    public List<UserModel> getAllList() {
        return userRepository.findByStatus(Status.ACTIVE);
    }

    public Optional<UserModel> authenticate(String email, String password) {
        Optional<UserModel> user = userRepository.findByEmail(email);
        boolean isAuthenticated = user.isPresent() && user.get().getPassword().equals(password);
        if (isAuthenticated) {
            return userRepository.findByEmail(email);
        } else {
            return null;
        }
    }
}
