package com.albgott.inventoryservice.business.domain.exception;

import com.albgott.inventoryservice.shared.domain.exception.WrongFormatException;

public class WrongBusinessNameFormat extends WrongFormatException {
    public WrongBusinessNameFormat(String businessName) {
        super("WRONG_BUSINESS_NAME_FORMAT", "The value \"" + businessName + "\" is not a valid BusinessName format.");
    }
}
