package com.daffodil.employeeApplication.exception;

import com.daffodil.employeeApplication.constants.Constants;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(Long id) {
        super(Constants.EMPLOYEE_NOT_FOUND + id);
    }
}
