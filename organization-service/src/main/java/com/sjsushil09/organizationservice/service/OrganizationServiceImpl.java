package com.sjsushil09.organizationservice.service;

import com.sjsushil09.organizationservice.dto.OrganizationDto;
import com.sjsushil09.organizationservice.entity.Organization;
import com.sjsushil09.organizationservice.mapper.OrganizationMapper;
import com.sjsushil09.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        organizationRepository.save(organization);
        OrganizationDto savedOrganization = OrganizationMapper.mapToOrganizationDto(organization);

        return savedOrganization;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.getOrganizationByOrganizationCode(organizationCode);
        OrganizationDto fetchedOrganization = OrganizationMapper.mapToOrganizationDto(organization);
        return fetchedOrganization;
    }
}
