package com.Ankit.EmployeManagement.service;

import com.Ankit.EmployeManagement.dto.requests.DepartmentRequestDto;
import com.Ankit.EmployeManagement.dto.response.DepartmentResponseDto;
import com.Ankit.EmployeManagement.exception.DepartementNotFoundException;
import com.Ankit.EmployeManagement.exception.DepartmentAlreadyExistsException;
import com.Ankit.EmployeManagement.model.Department;
import com.Ankit.EmployeManagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public Page<DepartmentResponseDto> getAllDepartments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Department> departmentPage = departmentRepository.findAll(pageable);

        return departmentPage
                .map(department -> {
                    return toResponseDto(department);
                });
    }

    public DepartmentResponseDto getDepartmentById(Long id) {
        Department department = departmentRepository
                .findById(id)
                .orElseThrow(() -> {
                    return  new DepartementNotFoundException("Department not found with id:" + id);
                });

        return toResponseDto(department);
    }

    public DepartmentResponseDto getDepartmentByName(String name) {
        String normalizedName = name.trim().toLowerCase();

        Department department = departmentRepository
                .findByName(normalizedName)
                .orElseThrow(() -> {
                    return new DepartementNotFoundException(
                            "Department not found with name: " + name
                    );
                });

        return modelMapper.map(department, DepartmentResponseDto.class);
    }

    public DepartmentResponseDto createDepartment(DepartmentRequestDto departementRequestDto) {
        String normalizedName = departementRequestDto.getName().trim().toLowerCase();

        if(departmentRepository.existsByName(normalizedName)) {
            throw new DepartmentAlreadyExistsException(
                    "Department already exists with the name :" + departementRequestDto.getName()
            );
        }

        departementRequestDto.setName(normalizedName);

        Department department = modelMapper.map(departementRequestDto, Department.class);
        departmentRepository.save(department);
        return modelMapper.map(department, DepartmentResponseDto.class);
    }

    public DepartmentResponseDto toResponseDto(Department department) {
        return modelMapper.map(department, DepartmentResponseDto.class);
    }
}
