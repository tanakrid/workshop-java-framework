package com.example.demoapp.employee;

import org.junit.jupiter.api.AfterEach;
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
    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    public void deleteDataForTest() {
        employeeRepository.deleteAll();
    }

    @Test
    void listEmployee() {

        EmployeeResponse[] results = restTemplate.getForObject("/employees", EmployeeResponse[].class);

        assertEquals(2, results.length);
    }

    @Test
    void checkGetEmployeeById() {
        // Arrange
        int id = 1;
        Employee employee100 = new Employee();
        employee100.setName("Tanakrid");
        employeeRepository.save(employee100);
        // Act
        EmployeeResponse result = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);

        assertEquals(1, result.getId());
        assertEquals("Tanakrid", result.getName());

    }
}