package com.example.demoapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id) {
        // validate input
        // Cleaning data

        EmployeeResponse response = employeeService.getById(Integer.parseInt(id));
        return response;
    }

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
