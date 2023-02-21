package com.sjsushil09.organizationservice.repository;

import com.sjsushil09.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    public Organization getOrganizationByOrganizationCode(String organizationCode);
}
