package com.albgott.inventoryservice.stock_product.application.create;

import lombok.NonNull;

import java.util.UUID;

public record CreateProductCommand(@NonNull UUID businessId, @NonNull UUID productId, @NonNull String productName) {
}
