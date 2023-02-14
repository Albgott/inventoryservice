package com.albgott.inventoryservice.business.application.create;

import com.albgott.inventoryservice.business.domain.Business;
import com.albgott.inventoryservice.business.domain.BusinessCreatedDomainEvent;
import com.albgott.inventoryservice.business.domain.BusinessRepository;
import com.albgott.inventoryservice.commons.domain.bus.event.DomainEventSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@DomainEventSubscriber({BusinessCreatedDomainEvent.class})
public class BusinessCreator {
    private BusinessRepository repository;

    @EventListener
    public void on(BusinessCreatedDomainEvent event){
        log.info("Received '{}[{}]' domain event with aggregate ID '{}' and name '{}'", event.eventName(), event.eventId(), event.aggregateId(), event.getName());

        repository.save(new Business(UUID.fromString(event.aggregateId()), event.getName()));

        log.info("Created new Business with id '{}' and name '{}'",event.aggregateId(),event.getName());
    }
}
