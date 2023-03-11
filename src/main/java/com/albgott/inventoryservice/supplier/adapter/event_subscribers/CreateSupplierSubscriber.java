package com.albgott.inventoryservice.supplier.adapter.event_subscribers;

import com.albgott.inventoryservice.shared.domain.event.DomainEventSubscriber;
import com.albgott.inventoryservice.supplier.create.CreateSupplierCommand;
import com.albgott.inventoryservice.supplier.create.CreateSupplierService;
import com.albgott.inventoryservice.supplier.domain.event.SupplierCreatedDomainEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@DomainEventSubscriber(SupplierCreatedDomainEvent.class)
public class CreateSupplierSubscriber {

    private final CreateSupplierService service;

    public CreateSupplierSubscriber(CreateSupplierService service) {
        this.service = service;
    }

    public void on(SupplierCreatedDomainEvent event){
        service.exec(new CreateSupplierCommand(
                UUID.fromString(event.getBusinessId()),
                UUID.fromString(event.aggregateId()),
                event.getName()
        ));
    }
}
