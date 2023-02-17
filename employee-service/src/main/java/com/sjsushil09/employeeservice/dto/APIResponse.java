package com.sjsushil09.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
