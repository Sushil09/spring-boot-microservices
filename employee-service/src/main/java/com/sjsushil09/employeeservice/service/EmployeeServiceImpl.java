package com.sjsushil09.employeeservice.service;

import com.sjsushil09.employeeservice.dto.EmployeeDto;
import com.sjsushil09.employeeservice.entity.Employee;
import com.sjsushil09.employeeservice.mapper.EmployeeMapper;
import com.sjsushil09.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        employeeRepository.save(employee);

        EmployeeDto returnedEmployee = EmployeeMapper.INSTANCE.employeeToDto(employee);

        return returnedEmployee;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        EmployeeDto fetchedEmployee = EmployeeMapper.INSTANCE.employeeToDto(employee);

        return fetchedEmployee;
    }
}
