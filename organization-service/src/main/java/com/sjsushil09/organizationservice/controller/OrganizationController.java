package com.sjsushil09.organizationservice.controller;

import com.sjsushil09.organizationservice.dto.OrganizationDto;
import com.sjsushil09.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    //save Organization RestAPI
    @PostMapping("")
    public ResponseEntity<OrganizationDto> saveOrganization (@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    //Get Organization by Organization Code RestAPI
    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> saveOrganization (@PathVariable("organizationCode") String organizationCode) {
        OrganizationDto fetchedOrganization = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(fetchedOrganization, HttpStatus.OK);
    }

}
