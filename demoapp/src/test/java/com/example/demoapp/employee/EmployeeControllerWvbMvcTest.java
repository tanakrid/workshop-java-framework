package com.example.demoapp.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.ContentResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class) // different with SpringBootTest that SBT will load all bean but MVCtest will load only bean that define
class EmployeeControllerWvbMvcTest {

    @Autowired
    private MockMvc mvc; // look like templateSpringTest

    @MockBean
    private EmployeeService employeeService;

    @Test
    void getEmployeeById() throws Exception {

        int id = 100;

        EmployeeResponse mockResponse = new EmployeeResponse();
        mockResponse.setId(100);
        mockResponse.setName("Mock name");
        when(employeeService.getById(100)).thenReturn(mockResponse);

        MvcResult result = mvc.perform(get("/employees/"+id)).andExpect(status().isOk()).andReturn();

        // Converting response data from byte to object. It will give benefit when response too big because it will with byte
        byte[] json = result.getResponse().getContentAsByteArray();
        ObjectMapper mapper = new ObjectMapper();
        EmployeeResponse response = mapper.readValue(json, EmployeeResponse.class);

        assertEquals(id, response.getId());
        assertEquals("Tanakrid", response.getName());

    }

    @Test
    void listEmployee() {
    }
}