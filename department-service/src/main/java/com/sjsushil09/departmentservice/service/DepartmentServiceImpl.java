package com.sjsushil09.departmentservice.service;

import com.sjsushil09.departmentservice.dto.DepartmentDto;
import com.sjsushil09.departmentservice.entity.Department;
import com.sjsushil09.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDescription(),
                departmentDto.getDepartmentCode()
        );

        departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDescription(),
                department.getDepartmentCode()
        );

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.getDepartmentByDepartmentCode(departmentCode);

        DepartmentDto fetchedDepartment = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDescription(),
                department.getDepartmentCode()
        );

        return fetchedDepartment;
    }
}
