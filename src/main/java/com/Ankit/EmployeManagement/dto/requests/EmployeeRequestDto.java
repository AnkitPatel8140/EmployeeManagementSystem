package com.Ankit.EmployeManagement.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EmployeeRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Email
    private String email;

    @NotNull
    private Double salary;

    @NotNull
    private String Department;
}

