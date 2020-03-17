package com.daffodil.employeeApplication.controller;

import com.daffodil.employeeApplication.entity.Department;
import com.daffodil.employeeApplication.entity.Employee;
import com.daffodil.employeeApplication.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testSaveEmployee() throws Exception {
        Employee emp = new Employee();
        Department dep = new Department();
        emp.setId(1);
        dep.setName("technology");
        emp.setName("Kapil");
        emp.setDepartment(dep);


        when(employeeService.saveEmployee(any(Employee.class))).thenReturn(emp);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/employee").content(mapper.writeValueAsString(emp))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertEquals(emp.getName(), mapper.readValue(result.getResponse().getContentAsString(), Employee.class).getName());

    }
}
