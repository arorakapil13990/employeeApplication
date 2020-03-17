package com.daffodil.employeeApplication.controller;

import com.daffodil.employeeApplication.entity.Department;
import com.daffodil.employeeApplication.entity.Employee;
import com.daffodil.employeeApplication.service.DepartmentService;
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
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testSaveDepartment() throws Exception {
        Department dep = new Department();
        dep.setId(1);
        dep.setName("technology");


        when(departmentService.saveDepartment(any(Department.class))).thenReturn(dep);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/department").content(mapper.writeValueAsString(dep))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertEquals(dep.getName(), mapper.readValue(result.getResponse().getContentAsString(), Department.class).getName());

    }
}
