package com.Ankit.EmployeManagement.controller;

import com.Ankit.EmployeManagement.dto.requests.EmployeeRequestDto;
import com.Ankit.EmployeManagement.dto.response.EmployeeResponseDto;
import com.Ankit.EmployeManagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    public final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees(@RequestParam int page, @RequestParam int size) {
        Page<EmployeeResponseDto> employeeResponseDtoPage = employeeService.getAllEmployee(page, size);
        return ResponseEntity.ok().body(employeeResponseDtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<EmployeeResponseDto>> getEmployeeByName(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int page,
            @RequestParam int size) {
        Page<EmployeeResponseDto> employeeResponseDtoPage = employeeService.getEmployeeByName(firstName, lastName, page, size);
        return ResponseEntity.ok().body(employeeResponseDtoPage);
    }

    @GetMapping("/search/{departement}")
    public ResponseEntity<Page<EmployeeResponseDto>> getEmployeeByDepartment(
            @PathVariable String department,
            @RequestParam int page,
            @RequestParam int size) {
        Page<EmployeeResponseDto> employeeResponseDtoPage = employeeService.getEmployeeByDepartment(department, page, size);
        return ResponseEntity.ok().body(employeeResponseDtoPage);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto employeeResponseDto = employeeService.createEmployee(employeeRequestDto);
        return ResponseEntity.ok().body(employeeResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable long id,
            @RequestBody EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto employeeResponseDto = employeeService.updateEmployee(id, employeeRequestDto);
        return ResponseEntity.ok().body(employeeResponseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }

}
