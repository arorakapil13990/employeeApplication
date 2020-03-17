package com.daffodil.employeeApplication.service;

import com.daffodil.employeeApplication.constants.Constants;
import com.daffodil.employeeApplication.entity.Department;
import com.daffodil.employeeApplication.exception.DepartmentNotFoundException;
import com.daffodil.employeeApplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }


    public Department findByDepartmentId(Long id) throws DepartmentNotFoundException {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    public String deleteDepartmentById(Long id){
         departmentRepository.deleteById(id);
         return Constants.DEPARTMENT_DELETED_SUCCESFULLY;
    }
}
