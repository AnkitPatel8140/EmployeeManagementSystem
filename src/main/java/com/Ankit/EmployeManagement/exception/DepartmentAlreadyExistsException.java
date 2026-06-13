package com.Ankit.EmployeManagement.exception;

import jakarta.validation.constraints.NotNull;

public class DepartmentAlreadyExistsException extends RuntimeException {
    public DepartmentAlreadyExistsException(String s) {
        super(s);
    }
}
