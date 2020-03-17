package com.daffodil.employeeApplication.service;

import com.daffodil.employeeApplication.constants.Constants;
import com.daffodil.employeeApplication.entity.Employee;
import com.daffodil.employeeApplication.exception.EmployeeNotFoundException;
import com.daffodil.employeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee findByEmployeeId(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public String deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return Constants.EMPLOYEE_DELETED_SUCCESFULLY;
    }
}
