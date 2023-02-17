package com.sjsushil09.departmentservice.service;

import com.sjsushil09.departmentservice.dto.DepartmentDto;
import com.sjsushil09.departmentservice.entity.Department;
import com.sjsushil09.departmentservice.exception.ResourceNotFoundException;
import com.sjsushil09.departmentservice.mapper.DepartmentMapper;
import com.sjsushil09.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.INSTANCE.dtoToDepartment(departmentDto);

        departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.INSTANCE.departmentToDto(department);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", departmentCode)
        );

        DepartmentDto fetchedDepartment = DepartmentMapper.INSTANCE.departmentToDto(department);

        return fetchedDepartment;
    }
}
