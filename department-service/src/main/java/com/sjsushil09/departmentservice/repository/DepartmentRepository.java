package com.sjsushil09.departmentservice.repository;

import com.sjsushil09.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department getDepartmentByDepartmentCode(String code);
}
