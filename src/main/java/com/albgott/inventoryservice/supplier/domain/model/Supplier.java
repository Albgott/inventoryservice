package com.albgott.inventoryservice.supplier.domain.model;

import com.albgott.inventoryservice.shared.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.NonNull;
import org.apache.commons.lang.Validate;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
public class Supplier extends AggregateRoot {
    @Id
    private UUID id;
    @Column(nullable = false, name = "business_id")
    private UUID businessId;
    @Column(nullable = false, name = "company_name")
    private String companyName;

    protected Supplier() {
    }

    public Supplier(@NonNull UUID id, @NonNull UUID businessId, @NonNull String companyName) {
        this.id = id;
        this.businessId = businessId;
        Validate.notEmpty(companyName.trim());
        this.companyName = companyName.trim().toLowerCase();
    }

    public String id() {
        return id.toString();
    }

    public String businessId() {
        return businessId.toString();
    }

    public String companyName() {
        return companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
