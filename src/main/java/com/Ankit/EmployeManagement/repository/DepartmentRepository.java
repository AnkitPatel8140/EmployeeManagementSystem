package com.Ankit.EmployeManagement.repository;

import com.Ankit.EmployeManagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
