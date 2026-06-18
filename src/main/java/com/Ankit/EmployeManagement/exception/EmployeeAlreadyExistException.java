package com.Ankit.EmployeManagement.exception;

import jakarta.validation.constraints.Email;

public class EmployeeAlreadyExistException extends RuntimeException {
    public EmployeeAlreadyExistException(String s) {
        super(s);
    }
}
