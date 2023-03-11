package com.albgott.inventoryservice.supplier.domain.event;

import com.albgott.inventoryservice.shared.domain.event.DomainEvent;
import com.albgott.inventoryservice.supplier.domain.model.Supplier;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;

@Getter
public class SupplierCreatedDomainEvent extends DomainEvent {
    private String businessId;
    private String name;

    public SupplierCreatedDomainEvent() {
    }

    public SupplierCreatedDomainEvent(Supplier supplier) {
        super(supplier.id());
        this.businessId = supplier.businessId();
        this.name = supplier.companyName();
    }

    public SupplierCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String businessId,
                                      String name) {
        super(aggregateId, eventId, occurredOn);
        this.businessId = businessId;
        this.name = name;
    }

    @Override
    public String eventName() {
        return "supplier.added";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
            put("businessId",businessId);
            put("name", name);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId,
                                      HashMap<String, Serializable> body,
                                      String eventId,
                                      String occurredOn) {
        return new SupplierCreatedDomainEvent(
                aggregateId,eventId,occurredOn,
                (String) body.get("businessId"),
                (String) body.get("name")
        );
    }
}
