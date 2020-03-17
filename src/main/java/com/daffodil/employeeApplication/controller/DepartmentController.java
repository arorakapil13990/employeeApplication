package com.daffodil.employeeApplication.controller;


import com.daffodil.employeeApplication.entity.Department;
import com.daffodil.employeeApplication.exception.DepartmentNotFoundException;
import com.daffodil.employeeApplication.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiOperation(value = "departmentController", notes = "Operations pertaining to Department", produces = "application/json")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    @ApiOperation(value = "Save Department ")
    public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Department By Id ")
    public ResponseEntity<?> findById(@PathVariable Long id) throws DepartmentNotFoundException {
        return new ResponseEntity<>(departmentService.findByDepartmentId(id), HttpStatus.OK);
    }


    @PutMapping
    @ApiOperation(value = "Update Department ")
    public ResponseEntity<?> updateDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.updateDepartment(department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.deleteDepartmentById(id), HttpStatus.OK);
    }

}
