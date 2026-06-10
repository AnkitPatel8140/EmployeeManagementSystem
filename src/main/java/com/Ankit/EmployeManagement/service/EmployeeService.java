package com.Ankit.EmployeManagement.service;

import com.Ankit.EmployeManagement.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeService {

    private final DepartmentRepository departmentRepository;


}
