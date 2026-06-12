package com.Ankit.EmployeManagement.dto.response;

import com.Ankit.EmployeManagement.model.Department;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EmployeeResponseDto {
    private Long id;

    private String firstName;
    private String lastName;

    private Double salary;

    private Department department;
}
