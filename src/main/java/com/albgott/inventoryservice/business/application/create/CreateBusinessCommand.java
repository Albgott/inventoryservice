package com.albgott.inventoryservice.business.application.create;

import com.albgott.inventoryservice.shared.application.Command;
import lombok.NonNull;

public record CreateBusinessCommand(@NonNull String id,@NonNull String name) implements Command {
}
