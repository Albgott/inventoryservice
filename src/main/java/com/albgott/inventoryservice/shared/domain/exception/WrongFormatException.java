package com.albgott.inventoryservice.shared.domain.exception;

public class WrongFormatException extends DomainException{
    public WrongFormatException(String code, String message) {
        super(code, message);
    }
}
