package com.Ankit.EmployeManagement.repository;

import com.Ankit.EmployeManagement.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByFirstName(String name, Pageable pageable);

    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    boolean existsByEmail(String email);

    Page<Employee> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);
}
