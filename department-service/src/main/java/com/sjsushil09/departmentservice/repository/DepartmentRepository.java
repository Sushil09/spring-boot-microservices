package com.sjsushil09.departmentservice.repository;

import com.sjsushil09.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Optional<Department> findDepartmentByDepartmentCode(String code);
}
