package com.albgott.inventoryservice.shared.application;

public interface CommandUseCase<C extends Command> {
    void exec(C command);
}
