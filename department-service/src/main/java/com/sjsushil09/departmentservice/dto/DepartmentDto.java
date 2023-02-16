package com.sjsushil09.departmentservice.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    public Long id;
    public String departmentName;
    public String description;
    public String departmentCode;
}
