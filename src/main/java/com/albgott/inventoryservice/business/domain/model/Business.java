package com.albgott.inventoryservice.business.domain.model;

import jakarta.persistence.*;
import org.apache.commons.lang.Validate;

@Entity
@Table(name = "businesses")
public class Business {
    @Id
    private BusinessId id;
    @Column(nullable = false,unique = true)
    private BusinessName name;

    public BusinessName getName() {
        return name;
    }

    protected Business(){}

    public Business(BusinessId id, BusinessName name) {
        Validate.notNull(id);
        Validate.notNull(name);
        this.id = id;
        this.name = name;
    }
}
