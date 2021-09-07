package com.example.demoapp.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Success case")
    public void case01() {
        int id = 1;
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Mock name");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        EmployeeResponse result = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);

        assertEquals(id, result.getId());
        assertEquals("Mock name", result.getName());
    }

    @Test
    @DisplayName("Failure case :: Employee not found id = 100")
    public void case02() {
        int id = 100;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/employees/" + id, ErrorResponse.class);

        assertEquals(404, result.getStatusCodeValue());
        assertEquals(404, result.getBody().getCode());
        assertEquals("Employee not found id = 100", result.getBody().getDetail());
    }
}
