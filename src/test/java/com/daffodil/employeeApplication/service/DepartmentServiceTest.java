package com.daffodil.employeeApplication.service;

import com.daffodil.employeeApplication.entity.Department;
import com.daffodil.employeeApplication.entity.Employee;
import com.daffodil.employeeApplication.exception.DepartmentNotFoundException;
import com.daffodil.employeeApplication.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService departmentService;
    @Mock
    private DepartmentRepository repository;


    @Test
    public void testFindEDepartmentById() throws DepartmentNotFoundException {

        Department dep = new Department();
        dep.setId(1);
        when(repository.findById(1L)).thenReturn(Optional.of(dep));
        assertNotNull(departmentService.findByDepartmentId(1L));

    }

    @Test
    public void testSaveDepartment() {
        Department dep = new Department();
        dep.setId(1);
        when(repository.save(any(Department.class))).thenReturn(dep);
        assertEquals(1, departmentService.saveDepartment(dep).getId());
    }


    @Test
    public void testUpdateDepartment() {
        Department dep = new Department();
        dep.setId(1);
        dep.setName("hr");
        when(repository.save(any(Department.class))).thenReturn(dep);
        assertEquals("hr", departmentService.updateDepartment(dep).getName());
    }
}
