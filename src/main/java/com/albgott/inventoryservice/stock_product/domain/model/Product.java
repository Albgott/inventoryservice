package com.albgott.inventoryservice.stock_product.domain.model;


import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "stock", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name","business_id"})
})
public class Product {
    @Column(name = "business_id")
    private UUID businessId;
    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private MeasurementUnit unit;

    protected Product() {
    }

    public Product(@NonNull UUID businessId, @NonNull UUID id, @NonNull String name) {
        this.businessId = businessId;
        this.id = id;
        this.name = name;
        this.quantity = 0;
        this.unit = MeasurementUnit.UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


