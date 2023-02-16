package com.albgott.inventoryservice.business.adapter.event_subcribers;

import com.albgott.inventoryservice.business.application.create.CreateBusinessCommand;
import com.albgott.inventoryservice.business.application.create.CreateBusinessServiceImpl;
import com.albgott.inventoryservice.business.domain.event.BusinessCreatedEvent;
import com.albgott.inventoryservice.shared.domain.event.DomainEventSubscriber;
import org.springframework.stereotype.Service;

@Service
@DomainEventSubscriber({BusinessCreatedEvent.class})
public class CreateBusiness {

    private final CreateBusinessServiceImpl service;

    public CreateBusiness(CreateBusinessServiceImpl service) {
        this.service = service;
    }

    public void on(BusinessCreatedEvent event){
        service.exec(new CreateBusinessCommand(event.aggregateId(), event.eventName()));
    }
}
