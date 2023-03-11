package com.albgott.inventoryservice.stock_product.infrastructure;

import com.albgott.inventoryservice.stock_product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, UUID> {
}
