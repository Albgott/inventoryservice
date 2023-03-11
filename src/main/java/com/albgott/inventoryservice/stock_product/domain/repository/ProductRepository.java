package com.albgott.inventoryservice.stock_product.domain.repository;

import com.albgott.inventoryservice.stock_product.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void save(Product product);
    boolean existsById(UUID id);
    void delete(Product product);
    Optional<Product> findById(UUID id);
}
