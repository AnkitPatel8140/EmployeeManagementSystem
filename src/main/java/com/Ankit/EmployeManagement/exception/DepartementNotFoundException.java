package com.Ankit.EmployeManagement.exception;

public class DepartementNotFoundException extends RuntimeException {
  public DepartementNotFoundException(Long id) {
    super("Departement not found for id" + id);
  }
}
