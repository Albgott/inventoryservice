package com.albgott.inventoryservice.business.infrastructure;

import com.albgott.inventoryservice.business.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaBusinessRepository extends JpaRepository<Business, UUID> {
}
