package com.albgott.inventoryservice.stock_product.adapter.event_subscribers;

import com.albgott.inventoryservice.shared.domain.event.DomainEventSubscriber;
import com.albgott.inventoryservice.stock_product.application.create.CreateProductCommand;
import com.albgott.inventoryservice.stock_product.application.create.CreateProductService;
import com.albgott.inventoryservice.stock_product.domain.event.ProductCreatedDomainEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@DomainEventSubscriber(ProductCreatedDomainEvent.class)
public class CreateProductSubscriber {

    private final CreateProductService service;

    public CreateProductSubscriber(CreateProductService service) {
        this.service = service;
    }

    public void on(ProductCreatedDomainEvent event){
        service.exec(new CreateProductCommand(
                UUID.fromString(event.getBusinessId()),
                UUID.fromString(event.aggregateId()),
                event.getName()
        ));
    }
}
