package com.albgott.inventoryservice.business.domain.exception;

import com.albgott.inventoryservice.shared.domain.exception.NotFoundExeption;

public class BusinessNotFound extends NotFoundExeption {
    public BusinessNotFound(String businessId) {
        super("BUSINESS_NOT_FOUND", String.format("Could not find business with id '%s'",businessId));
    }
}
