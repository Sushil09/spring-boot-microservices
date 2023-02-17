package com.sjsushil09.departmentservice.mapper;

import com.sjsushil09.departmentservice.dto.DepartmentDto;
import com.sjsushil09.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto departmentToDto(Department department);

    Department dtoToDepartment(DepartmentDto departmentDto);
}
