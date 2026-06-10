package com.Ankit.EmployeManagement.repository;

import com.Ankit.EmployeManagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DepartmentRepository implements JpaRepository<Department, Long> {
}
