package com.Ankit.EmployeManagement.service;

import com.Ankit.EmployeManagement.dto.requests.DepartmentRequestDto;
import com.Ankit.EmployeManagement.dto.response.DepartmentResponseDto;
import com.Ankit.EmployeManagement.exception.DepartementNotFoundException;
import com.Ankit.EmployeManagement.exception.DepartmentAlreadyExistsException;
import com.Ankit.EmployeManagement.model.Department;
import com.Ankit.EmployeManagement.repository.DepartmentRepository;
import com.Ankit.EmployeManagement.validation.CreateGroup;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public List<DepartmentResponseDto> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();

        return departmentList
                .stream()
                .map(department -> {
                    return toResponseDto(department);
                })
                .toList();
    }

    public DepartmentResponseDto getDepartment(Long id) {
        Department department = departmentRepository
                .findById(id)
                .orElseThrow(() -> {
                    return  new DepartementNotFoundException(id);
                });

        return toResponseDto(department);
    }

    public DepartmentResponseDto createDepartment(DepartmentRequestDto departementRequestDto) {
        String normalizedName = departementRequestDto.getName().trim().toLowerCase();

        if(departmentRepository.existsByName(normalizedName)) {
            throw new DepartmentAlreadyExistsException(
                    "Department already exists with the name :" + departementRequestDto.getName()
            );
        }
        Department department = modelMapper.map(departementRequestDto, Department.class);
        departmentRepository.save(department);
        return modelMapper.map(department, DepartmentResponseDto.class);
    }

    public DepartmentResponseDto toResponseDto(Department department) {
        return modelMapper.map(department, DepartmentResponseDto.class);
    }
}
