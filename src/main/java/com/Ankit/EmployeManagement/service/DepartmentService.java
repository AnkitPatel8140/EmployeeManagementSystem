package com.Ankit.EmployeManagement.service;

import com.Ankit.EmployeManagement.dto.DepartmentResponseDto;
import com.Ankit.EmployeManagement.exception.DepartementNotFoundException;
import com.Ankit.EmployeManagement.model.Department;
import com.Ankit.EmployeManagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
                    return modelMapper(department);
                })
                .toList();
    }

    public DepartmentResponseDto getDepartment(Long id) {
        Department department = departmentRepository
                .findById(id)
                .orElseThrow(()-> {return new DepartementNotFoundException(id);});

        return modelMapper(department);
    }

    public DepartmentResponseDto modelMapper(Department department) {
        return modelMapper.map(department, DepartmentResponseDto.class);
    }
}
