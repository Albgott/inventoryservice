package com.albgott.inventoryservice.shared.domain.exception;

public class NotFoundExeption extends DomainException{
    public NotFoundExeption(String code, String message) {
        super(code, message);
    }
}
