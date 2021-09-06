package com.example.demoapp.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // simulation start service
class EmployeeControllerTest {

    // similar postman
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void listEmployee() {

        EmployeeResponse[] results = restTemplate.getForObject("/employees", EmployeeResponse[].class);

        assertEquals(2, results.length);
    }

    @Test
    void checkGetEmployeeById() {
        EmployeeResponse result = restTemplate.getForObject("/employees/"+1, EmployeeResponse.class);

        assertEquals(1, result.getId());
        assertEquals("Tanakrid", result.getName());

    }
}