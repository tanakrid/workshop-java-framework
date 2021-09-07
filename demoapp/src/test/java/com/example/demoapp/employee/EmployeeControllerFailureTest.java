package com.example.demoapp.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerFailureTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("เกิด error 404 เมื่อค้นหา employee id = 1 ไม่เจอ")
    public void case01() {
        int id = 1;

        ResponseEntity<ErrorResponse> result = testRestTemplate.getForEntity("/employees/" + id, ErrorResponse.class);
        assertEquals(404, result.getStatusCodeValue());

        ErrorResponse resultBody = testRestTemplate.getForObject("/employees/" + id, ErrorResponse.class);
        assertEquals(404, resultBody.getCode());
        assertEquals("Employee not found id = 1", resultBody.getDetail());
    }

}
