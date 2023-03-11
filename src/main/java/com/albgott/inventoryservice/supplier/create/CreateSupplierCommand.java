package com.albgott.inventoryservice.supplier.create;

import lombok.NonNull;

import java.util.UUID;

public record CreateSupplierCommand(@NonNull UUID businessId, @NonNull UUID supplierId,@NonNull String companyName) {
}
