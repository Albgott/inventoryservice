package com.albgott.inventoryservice.shared.domain.exception;

public class ForbiddenException extends DomainException{

    public ForbiddenException(String code, String message) {
        super(code, message);
    }
}
