package com.sjsushil09.employeeservice.service;

import com.sjsushil09.employeeservice.dto.APIResponse;
import com.sjsushil09.employeeservice.dto.DepartmentDto;
import com.sjsushil09.employeeservice.dto.EmployeeDto;
import com.sjsushil09.employeeservice.entity.Employee;
import com.sjsushil09.employeeservice.exception.ResourceNotFoundException;
import com.sjsushil09.employeeservice.mapper.EmployeeMapper;
import com.sjsushil09.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        employeeRepository.save(employee);

        EmployeeDto returnedEmployee = EmployeeMapper.INSTANCE.employeeToDto(employee);

        return returnedEmployee;
    }

    @Override
    public APIResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        EmployeeDto fetchedEmployee = EmployeeMapper.INSTANCE.employeeToDto(employee);
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.
                getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();


        return new APIResponse(fetchedEmployee,departmentDto);
    }
}
