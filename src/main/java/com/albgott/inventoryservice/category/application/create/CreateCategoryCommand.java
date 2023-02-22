package com.albgott.inventoryservice.category.application.create;

import com.albgott.inventoryservice.shared.application.Command;
import lombok.NonNull;

public record CreateCategoryCommand(@NonNull String id, @NonNull String name, String description, int[] color,
                                    @NonNull String businessId) implements Command {
}
