package com.example.demoapp.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee() {

        EmployeeResponse emp = new EmployeeResponse();
        emp.setId(1);
        emp.setName("Tanakrid");

        EmployeeResponse emp2 = new EmployeeResponse();
        emp2.setId(2);
        emp2.setName("WWW");
        return new EmployeeResponse[]{ emp, emp2 };
    }
}
