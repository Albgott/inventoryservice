package com.albgott.inventoryservice.stock_product.infrastructure;

import com.albgott.inventoryservice.stock_product.domain.model.Product;
import com.albgott.inventoryservice.stock_product.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository repository;

    public ProductRepositoryImpl(JpaProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id);
    }
}
