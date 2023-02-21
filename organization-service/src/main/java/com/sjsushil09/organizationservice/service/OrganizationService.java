package com.sjsushil09.organizationservice.service;

import com.sjsushil09.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization (OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode (String organizationCode);
}
