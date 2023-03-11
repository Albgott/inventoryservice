package com.albgott.inventoryservice.stock_product.domain.event;

import com.albgott.inventoryservice.shared.domain.event.DomainEvent;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;

@Getter
public class ProductCreatedDomainEvent extends DomainEvent {
    private String name;
    private String businessId;

    public ProductCreatedDomainEvent() {
    }


    public ProductCreatedDomainEvent(String aggregateId, String eventId, String occurredOn,String name,
                                     String businessId) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.businessId = businessId;
    }

    @Override
    public String eventName() {
        return "product.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
            put("name",name);
            put("businessId", businessId);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId,
                                      HashMap<String, Serializable> body,
                                      String eventId,
                                      String occurredOn) {
        return new ProductCreatedDomainEvent(
                aggregateId,eventId,occurredOn,
                (String) body.get("name"),
                (String) body.get("businessId")
        );
    }
}
