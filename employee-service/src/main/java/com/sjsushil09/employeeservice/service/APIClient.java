package com.sjsushil09.employeeservice.service;

import com.sjsushil09.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable("code") String departmentCode);

}
