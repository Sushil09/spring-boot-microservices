package com.sjsushil09.departmentservice.service;

import com.sjsushil09.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    public DepartmentDto saveDepartment (DepartmentDto departmentDto);

    public DepartmentDto getDepartmentByCode (String departmentCode);
}
