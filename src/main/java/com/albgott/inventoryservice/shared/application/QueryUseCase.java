package com.albgott.inventoryservice.shared.application;

public interface QueryUseCase<Q extends Query, R extends Response> {
    R exec(Q query);
}
