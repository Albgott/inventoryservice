package com.albgott.inventoryservice.commons.application;

public interface QueryUseCase<I extends Request, O extends  Response>{
    O execute(I request);
}
