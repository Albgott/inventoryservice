package com.albgott.inventoryservice.business.infrastructure;

import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.business.domain.model.BusinessId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBusinessRepository extends JpaRepository<Business, BusinessId> {
}

