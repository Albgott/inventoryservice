package com.albgott.inventoryservice.business.infrastructure;

import com.albgott.inventoryservice.business.domain.Business;
import com.albgott.inventoryservice.business.domain.BusinessRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessRepositoryImpl implements BusinessRepository {
    private final JpaBusinessRepository repository;

    public BusinessRepositoryImpl(JpaBusinessRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Business business) {
        repository.save(business);
    }
}
