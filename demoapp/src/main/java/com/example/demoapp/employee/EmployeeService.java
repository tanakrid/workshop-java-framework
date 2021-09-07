package com.example.demoapp.employee;

import org.springframework.stereotype.Service;

@Service // use when want to change some class that should be service so affect is created this class to be bean since start service
public class EmployeeService {

    public EmployeeResponse getById(int parseInt) {
        EmployeeResponse emp = new EmployeeResponse();
        emp.setId(parseInt);
        emp.setName("Tanakrid");
        return emp;
    }
}
