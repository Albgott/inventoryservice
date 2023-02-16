package com.albgott.inventoryservice.business.domain.exception;

import com.albgott.inventoryservice.shared.domain.exception.WrongFormatException;

public class WrongBusinessIDFormat extends WrongFormatException {

    public WrongBusinessIDFormat(String businessId) {
        super("WRONG_BUSINESS_ID_FORMAT", "The value \"" + businessId + "\" is not a valid BusinessId format.");
    }
}