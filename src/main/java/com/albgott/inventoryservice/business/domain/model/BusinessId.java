package com.albgott.inventoryservice.business.domain.model;

import com.albgott.inventoryservice.business.domain.exception.WrongBusinessIDFormat;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class BusinessId implements Serializable {
    private final UUID value;

    public BusinessId(String id) {
        try {
            this.value = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new WrongBusinessIDFormat(id);
        }
    }

    public UUID value() {
        return value;
    }

    @Override
    public String toString() {
        return value().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessId that = (BusinessId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
