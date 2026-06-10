package com.Ankit.EmployeManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Email
    private String email;

    @NotNull
    private Double salary;
}

