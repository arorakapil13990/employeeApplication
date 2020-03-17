package com.daffodil.employeeApplication.service;

import com.daffodil.employeeApplication.entity.Employee;
import com.daffodil.employeeApplication.exception.EmployeeNotFoundException;
import com.daffodil.employeeApplication.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private EmployeeRepository repository;


    @Test
    public void testFindEmployeeById() throws EmployeeNotFoundException {
        Employee emp = new Employee();
        emp.setId(1);
        when(repository.findById(1L)).thenReturn(Optional.of(emp));
        assertNotNull(employeeService.findByEmployeeId(1L));
    }


    @Test
    public void testSaveEmployee() {
        Employee emp = new Employee();
        emp.setId(1);
        when(repository.save(any(Employee.class))).thenReturn(emp);
        assertEquals(1, employeeService.saveEmployee(emp).getId());
    }



    @Test
    public void testUpdateEmployee() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Kapil");
        when(repository.save(any(Employee.class))).thenReturn(emp);
        assertEquals("Kapil", employeeService.saveEmployee(emp).getName());
    }
}
