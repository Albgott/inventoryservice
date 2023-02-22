package com.albgott.inventoryservice.category.application.modify;

import com.albgott.inventoryservice.shared.application.Command;
import lombok.NonNull;

public record ModifyCategoryCommand(@NonNull String categoryId, String categoryName, String categoryDescription,
                                    int[] color) implements Command {
}
