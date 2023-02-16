package com.sjsushil09.employeeservice.service;

import com.sjsushil09.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto saveEmployee (EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById (Long id);

}
