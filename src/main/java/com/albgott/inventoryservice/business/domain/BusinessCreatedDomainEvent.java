package com.albgott.inventoryservice.business.domain;

import com.albgott.inventoryservice.commons.domain.bus.event.DomainEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@NoArgsConstructor
public class BusinessCreatedDomainEvent extends DomainEvent {
    private String name;

    public BusinessCreatedDomainEvent(String aggregateId, String name) {
        super(aggregateId);
        this.name = name;
    }

    public BusinessCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name) {
        super(aggregateId,eventId,occurredOn);
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
        return new BusinessCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name")
        );
    }
}
