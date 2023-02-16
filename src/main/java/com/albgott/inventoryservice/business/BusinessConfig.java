package com.albgott.inventoryservice.business;

import com.albgott.inventoryservice.business.application.create.CreateBusinessService;
import com.albgott.inventoryservice.business.application.create.CreateBusinessServiceImpl;
import com.albgott.inventoryservice.business.application.create.CreateBusinessServiceProxy;
import com.albgott.inventoryservice.shared.domain.security.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {
    @Bean
    public CreateBusinessService createBusinessService(CreateBusinessServiceImpl service, SecurityService securityService){
        return new CreateBusinessServiceProxy(service,securityService);
    }
}
