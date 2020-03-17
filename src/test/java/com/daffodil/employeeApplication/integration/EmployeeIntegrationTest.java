package com.daffodil.employeeApplication.integration;

import com.daffodil.employeeApplication.entity.Department;
import com.daffodil.employeeApplication.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeIntegrationTest {

    @Autowired
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testSaveEmployee() throws Exception {
        Employee emp = new Employee();
        Department dep = new Department();
        dep.setName("technology");
        emp.setName("Kapil");
        emp.setDepartment(dep);
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.post("/employee").content(mapper.writeValueAsString(emp))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertEquals(emp.getName(), mapper.readValue(result.getResponse().getContentAsString(), Employee.class).getName());

    }
}
