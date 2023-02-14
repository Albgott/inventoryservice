package com.albgott.inventoryservice.commons.domain;

public abstract class DomainException extends RuntimeException {
    public DomainException(String message){
        super(message);
    }
}
