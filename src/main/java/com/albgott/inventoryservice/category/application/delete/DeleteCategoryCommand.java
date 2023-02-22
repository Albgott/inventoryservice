package com.albgott.inventoryservice.category.application.delete;

import com.albgott.inventoryservice.shared.application.Command;
import lombok.NonNull;

public record DeleteCategoryCommand(@NonNull String categoryId) implements Command {
}
