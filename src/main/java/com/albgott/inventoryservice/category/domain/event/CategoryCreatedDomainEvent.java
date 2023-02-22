package com.albgott.inventoryservice.category.domain.event;

import com.albgott.inventoryservice.shared.domain.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class CategoryCreatedDomainEvent extends DomainEvent {

    private String businessId;
    private String categoryName;

    public CategoryCreatedDomainEvent() {
    }

    public CategoryCreatedDomainEvent(String aggregateId, String businessId, String categoryName) {
        super(aggregateId);
        this.businessId = businessId;
        this.categoryName = categoryName;
    }

    public CategoryCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String businessId,
                                      String categoryName) {
        super(aggregateId, eventId, occurredOn);
        this.businessId = businessId;
        this.categoryName = categoryName;
    }

    @Override
    public String eventName() {
        return "category.added";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
            put("business_id",businessId);
            put("category_name", categoryName);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId,
                                      HashMap<String, Serializable> body,
                                      String eventId,
                                      String occurredOn) {
        return new CategoryCreatedDomainEvent(
                aggregateId, eventId, occurredOn,
                (String) body.get("business_id"),
                (String) body.get("category_name")
        );
    }
}
