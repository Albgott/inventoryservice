package com.albgott.inventoryservice.business.application.create;

import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.business.domain.model.BusinessId;
import com.albgott.inventoryservice.business.domain.model.BusinessName;
import com.albgott.inventoryservice.business.domain.repository.BusinessRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateBusinessServiceImpl implements CreateBusinessService {
    private final BusinessRepository repository;

    public CreateBusinessServiceImpl(BusinessRepository repository) {
        this.repository = repository;
    }

    public void exec(CreateBusinessCommand command){
        Business business = new Business(new BusinessId(command.id()), new BusinessName(command.name()));
        repository.save(business);
    }
}
