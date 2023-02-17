package com.sjsushil09.employeeservice.controller;

import com.sjsushil09.employeeservice.dto.APIResponse;
import com.sjsushil09.employeeservice.dto.EmployeeDto;
import com.sjsushil09.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeToSave = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeToSave, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getEmployeeById (@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id),
                HttpStatus.OK);
    }
}
