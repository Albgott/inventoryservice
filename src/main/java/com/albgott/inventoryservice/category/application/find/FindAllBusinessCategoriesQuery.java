package com.albgott.inventoryservice.category.application.find;

import com.albgott.inventoryservice.shared.application.Query;
import lombok.NonNull;

public record FindAllBusinessCategoriesQuery(@NonNull String businessId) implements Query {
}
