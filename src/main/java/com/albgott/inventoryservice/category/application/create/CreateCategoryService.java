package com.albgott.inventoryservice.category.application.create;

import com.albgott.inventoryservice.business.domain.exception.BusinessNotFound;
import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.business.domain.model.BusinessId;
import com.albgott.inventoryservice.business.domain.repository.BusinessRepository;
import com.albgott.inventoryservice.category.domain.event.CategoryCreatedDomainEvent;
import com.albgott.inventoryservice.category.domain.model.Category;
import com.albgott.inventoryservice.category.domain.repository.CategoryRepository;
import com.albgott.inventoryservice.shared.application.CommandUseCase;
import com.albgott.inventoryservice.shared.domain.event.EventBus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class CreateCategoryService implements CommandUseCase<CreateCategoryCommand> {

    private final EventBus eventBus;
    private final BusinessRepository businessRepository;
    private final CategoryRepository categoryRepository;

    public CreateCategoryService(EventBus eventBus,
                                 BusinessRepository businessRepository,
                                 CategoryRepository categoryRepository) {
        this.eventBus = eventBus;
        this.businessRepository = businessRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void exec(CreateCategoryCommand command) {
        Category category = createCategoryFromCommand(command);

        categoryRepository.save(category);
        eventBus.publish(List.of(
                new CategoryCreatedDomainEvent(category.id(),category.businessId(), category.name())
        ));
    }

    private Category createCategoryFromCommand(CreateCategoryCommand command) {
        Business business = getBusinessFromCommand(command);
        Color color = null;
        if(command.color().length == 3){
            color = new Color(command.color()[0],command.color()[1],command.color()[2]);
        }
        return new Category(
                UUID.fromString(command.id()),
                command.name(),
                command.description(),
                color,
                business
        );
    }

    private Business getBusinessFromCommand(CreateCategoryCommand command) {
        return businessRepository.findById(new BusinessId(command.businessId()))
                .orElseThrow(() -> new BusinessNotFound(command.businessId()));
    }
}
