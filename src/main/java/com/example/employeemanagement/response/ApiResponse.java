package com.example.employeemanagement.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private Long id;
    private String message;

    public ApiResponse(Long id, String message) {
        this.id = id;
        this.message = message;
    }

}
