package com.daffodil.employeeApplication.exception;

import com.daffodil.employeeApplication.constants.Constants;

public class DepartmentNotFoundException extends Exception {

    public DepartmentNotFoundException(Long id) {
        super(Constants.DEPARTMENT_NOT_FOUND + id);
    }
}
