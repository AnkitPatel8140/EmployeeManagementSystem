package com.Ankit.EmployeManagement.dto;

import com.Ankit.EmployeManagement.model.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
    private Long id;

    private String firstName;
    private String lastName;

    private Double salary;

    private Department department;
}
