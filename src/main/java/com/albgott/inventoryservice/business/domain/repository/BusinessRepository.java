package com.albgott.inventoryservice.business.domain.repository;

import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.business.domain.model.BusinessId;

import java.util.Optional;

public interface BusinessRepository {
    void save(Business business);
    void delete(Business business);
    void delete(BusinessId businessId);
    Optional<Business> findById(BusinessId id);
}
