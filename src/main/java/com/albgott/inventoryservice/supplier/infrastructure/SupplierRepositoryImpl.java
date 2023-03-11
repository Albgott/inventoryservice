package com.albgott.inventoryservice.supplier.infrastructure;

import com.albgott.inventoryservice.supplier.domain.model.Supplier;
import com.albgott.inventoryservice.supplier.domain.repository.SupplierRespository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class SupplierRepositoryImpl implements SupplierRespository {

    private final JpaSupplierRepository repository;

    public SupplierRepositoryImpl(JpaSupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Supplier supplier) {
        repository.save(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        repository.delete(supplier);
    }

    @Override
    public boolean isNameUsedOnBusiness(String name, UUID businessId) {
        return repository.existsByCompanyNameIgnoreCaseAndBusinessId(name,businessId);
    }

    @Override
    public Optional<Supplier> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
