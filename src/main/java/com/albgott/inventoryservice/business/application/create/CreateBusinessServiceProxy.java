package com.albgott.inventoryservice.business.application.create;

import com.albgott.inventoryservice.shared.domain.security.SecurityService;
import org.springframework.stereotype.Component;

@Component
public class CreateBusinessServiceProxy implements CreateBusinessService {

    private final CreateBusinessServiceImpl service;
    private final SecurityService securityService;

    public CreateBusinessServiceProxy(CreateBusinessServiceImpl service, SecurityService securityService) {
        this.service = service;
        this.securityService = securityService;
    }

    @Override
    public void exec(CreateBusinessCommand command) {
        service.exec(command);
    }
}
