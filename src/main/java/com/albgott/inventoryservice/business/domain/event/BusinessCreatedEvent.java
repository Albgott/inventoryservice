package com.albgott.inventoryservice.business.domain.event;

import com.albgott.inventoryservice.shared.domain.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class BusinessCreatedEvent extends DomainEvent {
    private String name;

    public BusinessCreatedEvent() {
    }

    public BusinessCreatedEvent(String aggregateId, String name) {
        super(aggregateId);
        this.name = name;
    }

    public BusinessCreatedEvent(String aggregateId, String eventId, String occurredOn, String name) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
    }

    @Override
    public String eventName() {
        return "business.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
            put("name",name);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId,
                                      HashMap<String, Serializable> body,
                                      String eventId,
                                      String occurredOn) {
        return new BusinessCreatedEvent(aggregateId,eventId,occurredOn,(String) body.get("name"));
    }

    public String name() {
        return name;
    }
}
