package com.sjsushil09.employeeservice.repository;

import com.sjsushil09.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
