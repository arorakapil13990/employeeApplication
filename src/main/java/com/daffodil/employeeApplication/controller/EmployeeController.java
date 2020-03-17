package com.daffodil.employeeApplication.controller;

import com.daffodil.employeeApplication.entity.Employee;
import com.daffodil.employeeApplication.exception.EmployeeNotFoundException;
import com.daffodil.employeeApplication.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ApiOperation(value = "employeeController", notes = "Operations pertaining to Employee", produces = "application/json")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    @ApiOperation(value = "Save Employee ")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = " Find Employee by Id ")
    public ResponseEntity<?> findById(@PathVariable Long id) throws EmployeeNotFoundException {
        return new ResponseEntity<>(employeeService.findByEmployeeId(id), HttpStatus.OK);
    }


    @PutMapping
    @ApiOperation(value = "Update Employee ")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }



}
