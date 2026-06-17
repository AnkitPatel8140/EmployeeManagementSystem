package com.Ankit.EmployeManagement.service;

import com.Ankit.EmployeManagement.dto.requests.EmployeeRequestDto;
import com.Ankit.EmployeManagement.dto.response.EmployeeResponseDto;
import com.Ankit.EmployeManagement.exception.DepartmentNotFoundException;
import com.Ankit.EmployeManagement.exception.EmployeeNotFoundException;
import com.Ankit.EmployeManagement.model.Department;
import com.Ankit.EmployeManagement.model.Employee;
import com.Ankit.EmployeManagement.model.EmployeeStatus;
import com.Ankit.EmployeManagement.repository.DepartmentRepository;
import com.Ankit.EmployeManagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

   public Page<EmployeeResponseDto> getAllEmployee(int page, int size) {
       Pageable pageable = PageRequest.of(page, size);

       Page<Employee> employeePage = employeeRepository.findAll(pageable);

       return employeePage
               .map((employee) -> {
                   return modelMapper.map(employee, EmployeeResponseDto.class);
               });
   }

   public EmployeeResponseDto getEmployeeById(Long id) {
       if(!employeeRepository.existsById(id)) {
           throw new EmployeeNotFoundException("Employee Not Found with id : "+id);
       }

       Employee employee = employeeRepository
               .findById(id)
               .orElseThrow(()-> {
                   return new EmployeeNotFoundException("Employee Not Fond with id : "+ id);
               });

       return modelMapper.map(employee, EmployeeResponseDto.class);
   }

   public Page<EmployeeResponseDto> getEmployeeByName(String name, int page, int size) {
       Pageable pageable = PageRequest.of(page, size);

       Page<Employee> employeePage = employeeRepository.findByName(name, pageable);

       return employeePage.map((employee)-> {
           return modelMapper.map(employee, EmployeeResponseDto.class);
       });
   }

   public Page<EmployeeResponseDto> getEmployeeByDepartment(String departmentName, int page, int size) {
       Pageable pageable = PageRequest.of(page, size);
       Page<Employee> employeePage = employeeRepository.findByDepartmentName(departmentName, pageable);

       return employeePage.map(employee -> {
           return modelMapper.map(employee, EmployeeResponseDto.class);
       });
   }



   public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
       String normalize = employeeRequestDto.getDepartment().toLowerCase();

       if(!departmentRepository.existsByName(normalize)) {
           throw new DepartmentNotFoundException("Department does not exist with name : " + normalize);
       }

       Department department = departmentRepository.findByName(normalize).get();

       Employee employee = new Employee();

       employee.setDepartment(department);
       employee.setFirstName(employeeRequestDto.getFirstName().toLowerCase());
       employee.setLastName(employeeRequestDto.getLastName().toLowerCase());
       employee.setEmail(employeeRequestDto.getEmail());
       employee.setSalary(employeeRequestDto.getSalary());
       employee.setJoiningDate(LocalDate.now());
       employee.setStatus(EmployeeStatus.ACTIVE);

       Employee savedEmployee = employeeRepository.save(employee);

       return modelMapper.map(savedEmployee, EmployeeResponseDto.class);
   }

//   update employee
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeRequestDto) {
       if(!employeeRepository.existsById(id)) {
           throw new EmployeeNotFoundException("Employee does not exist with id : "+id);
       }

       String departmentName = employeeRequestDto.getDepartment().toLowerCase();

       if(!departmentRepository.existsByName(departmentName)) {
           throw new DepartmentNotFoundException("Departement does not exist with name : " + departmentName);
       }

       Employee employee = employeeRepository.findById(id).get();
       Department department  = departmentRepository.findByName(departmentName).get();

       employee.setDepartment(department);
       employee.setFirstName(employeeRequestDto.getFirstName().trim().toLowerCase());
       employee.setLastName(employeeRequestDto.getLastName().toLowerCase());
       employee.setEmail(employeeRequestDto.getEmail());
       employee.setSalary(employeeRequestDto.getSalary());

       String status = employeeRequestDto.getStatus().toLowerCase();
       EmployeeStatus employeeStatus = status.equals("active") ? EmployeeStatus.ACTIVE : EmployeeStatus.INACTIVE;

       employee.setStatus(employeeStatus);

       Employee updatedEmployee = employeeRepository.save(employee);

       return modelMapper.map(updatedEmployee, EmployeeResponseDto.class);
    }
//    delete employee


}
