package com.sjsushil09.departmentservice.controller;


import com.sjsushil09.departmentservice.dto.DepartmentDto;
import com.sjsushil09.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("")
    public ResponseEntity<DepartmentDto> saveDepartment (@RequestBody DepartmentDto departmentDto) {
        DepartmentDto requestDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(requestDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String departmentCode) {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode)
                ,HttpStatus.OK);
    }
}
