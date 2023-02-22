package com.albgott.inventoryservice.category.domain.event;

import com.albgott.inventoryservice.shared.domain.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class CategoryNameModifiedDomainEvent extends DomainEvent {
    private String newName;

    public CategoryNameModifiedDomainEvent() {}

    public CategoryNameModifiedDomainEvent(String aggregateId, String newName) {
        super(aggregateId);
        this.newName = newName;
    }

    public CategoryNameModifiedDomainEvent(String aggregateId, String eventId, String occurredOn, String newName) {
        super(aggregateId, eventId, occurredOn);
        this.newName = newName;
    }

    @Override
    public String eventName() {
        return "category.name.modified";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
            put("name", newName);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId,
                                      HashMap<String, Serializable> body,
                                      String eventId,
                                      String occurredOn) {
        return new CategoryNameModifiedDomainEvent(
                aggregateId,eventId,occurredOn,
                (String) body.get("name")
        );
    }
}
