package com.Ankit.EmployeManagement.controller;

import com.Ankit.EmployeManagement.dto.DepartmentResponseDto;
import com.Ankit.EmployeManagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/")
    public List<DepartmentResponseDto> getAllDepartements() {
        return departmentService.getAllDepartments();
    }
}
