package com.albgott.inventoryservice.supplier.domain.repository;

import com.albgott.inventoryservice.supplier.domain.model.Supplier;

import java.util.Optional;
import java.util.UUID;

public interface SupplierRespository {
    void save(Supplier supplier);
    void delete(Supplier supplier);
    boolean isNameUsedOnBusiness(String name, UUID businessId);
    Optional<Supplier> findById(UUID id);
    boolean existsById(UUID id);
}
