package com.example.demoapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // use when want to change some class that should be service so affect is created this class to be bean since start service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse getById(int parseInt) {
        Optional<Employee> result = employeeRepository.findById(parseInt);

        if (result.isPresent()) {
            EmployeeResponse response = new EmployeeResponse();
            response.setId(result.get().getId());
            response.setName(result.get().getName());
            return response;
        }
        throw new EmployeeNotFoundException("Employee not found id = " + parseInt);
    }
}
