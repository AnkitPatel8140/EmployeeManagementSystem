package com.Ankit.EmployeManagement.controller;

import com.Ankit.EmployeManagement.dto.response.EmployeeResponseDto;
import com.Ankit.EmployeManagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller("/Employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees(@RequestParam int page, @RequestParam int size) {
        Page<EmployeeResponseDto> employeeResponseDtoPage = employeeService.getAllEmployee(page, size);
        return ResponseEntity.ok().body(employeeResponseDtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

}
