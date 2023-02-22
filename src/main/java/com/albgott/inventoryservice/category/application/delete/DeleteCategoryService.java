package com.albgott.inventoryservice.category.application.delete;

import com.albgott.inventoryservice.category.domain.event.CategoryDeletedDomainEvent;
import com.albgott.inventoryservice.category.domain.repository.CategoryRepository;
import com.albgott.inventoryservice.shared.application.CommandUseCase;
import com.albgott.inventoryservice.shared.domain.event.EventBus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class DeleteCategoryService implements CommandUseCase<DeleteCategoryCommand> {

    private final EventBus eventBus;
    private final CategoryRepository categoryRepository;

    public DeleteCategoryService(EventBus eventBus, CategoryRepository categoryRepository) {
        this.eventBus = eventBus;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void exec(DeleteCategoryCommand command) {
        categoryRepository.delete(UUID.fromString(command.categoryId()));
        eventBus.publish(List.of(
                new CategoryDeletedDomainEvent(command.categoryId())
        ));
    }
}
