package com.albgott.inventoryservice.category.application.find;

import com.albgott.inventoryservice.shared.application.Query;
import lombok.NonNull;

public record FindCategoryByIdQuery(@NonNull String categoryId) implements Query {
}
