package com.sjsushil09.employeeservice.service;

import com.sjsushil09.employeeservice.dto.APIResponse;
import com.sjsushil09.employeeservice.dto.DepartmentDto;
import com.sjsushil09.employeeservice.dto.EmployeeDto;
import com.sjsushil09.employeeservice.entity.Employee;
import com.sjsushil09.employeeservice.exception.ResourceNotFoundException;
import com.sjsushil09.employeeservice.mapper.EmployeeMapper;
import com.sjsushil09.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;
    private WebClient webClient;
//    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        employeeRepository.save(employee);

        EmployeeDto returnedEmployee = EmployeeMapper.INSTANCE.employeeToDto(employee);

        return returnedEmployee;
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        EmployeeDto fetchedEmployee = EmployeeMapper.INSTANCE.employeeToDto(employee);

//        Using Rest-Template Client
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.
//                getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//        Using WebClient
        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve().bodyToMono(DepartmentDto.class)
                .block();

//        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        return new APIResponse(fetchedEmployee,departmentDto);
    }

    public APIResponse getDefaultDepartment (Long id, Exception exception) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        EmployeeDto fetchedEmployee = EmployeeMapper.INSTANCE.employeeToDto(employee);

//        Using WebClient
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("Research & Development");
        departmentDto.setDepartmentCode("R&D");
        departmentDto.setDescription("R & D Department in organization");

        return new APIResponse(fetchedEmployee,departmentDto);
    }
}
