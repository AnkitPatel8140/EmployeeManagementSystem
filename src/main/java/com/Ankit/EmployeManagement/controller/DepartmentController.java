package com.Ankit.EmployeManagement.controller;

import com.Ankit.EmployeManagement.dto.requests.DepartmentRequestDto;
import com.Ankit.EmployeManagement.dto.response.DepartmentResponseDto;
import com.Ankit.EmployeManagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/")
    public ResponseEntity<Page<DepartmentResponseDto>> getAllDepartements(@RequestParam int page, @RequestParam int size) {
        Page<DepartmentResponseDto> response = departmentService.getAllDepartments(page, size);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getDepartementById(@PathVariable long id) {
        return ResponseEntity.ok().body(departmentService.getDepartmentById(id));
    }

    @GetMapping("/name/{name}")
    public DepartmentResponseDto getDepartmentByName(@PathVariable String name) {
        return departmentService.getDepartmentByName(name);
    }

    @PostMapping("/")
    public DepartmentResponseDto createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto) {
        return departmentService.createDepartment(departmentRequestDto);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDto updateDepartment(@PathVariable Long id,@RequestBody DepartmentRequestDto departmentRequestDto) {
        return departmentService.updateDepartment(id, departmentRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
