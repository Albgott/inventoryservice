package com.albgott.inventoryservice.category.application.modify;

import com.albgott.inventoryservice.category.domain.exception.CategoryNotFound;
import com.albgott.inventoryservice.category.domain.model.Category;
import com.albgott.inventoryservice.category.domain.repository.CategoryRepository;
import com.albgott.inventoryservice.shared.application.CommandUseCase;
import com.albgott.inventoryservice.shared.domain.event.EventBus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.UUID;

@Transactional
@Service
public class ModifyCategoryService implements CommandUseCase<ModifyCategoryCommand> {

    private final EventBus eventBus;
    private final CategoryRepository categoryRepository;

    public ModifyCategoryService(EventBus eventBus, CategoryRepository categoryRepository) {
        this.eventBus = eventBus;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void exec(ModifyCategoryCommand command) {
        Category category = getCategoryFromCommand(command);

        category.modifyColor(getColor(command.color()));
        category.modifyDescription(command.categoryDescription());
        category.modifyName(command.categoryName());

        categoryRepository.save(category);
        eventBus.publish(category.pullDomainEvents());
    }

    private Category getCategoryFromCommand(ModifyCategoryCommand command) {
        return categoryRepository.findById(UUID.fromString(command.categoryId()))
                .orElseThrow(() -> new CategoryNotFound(command.categoryId()));
    }

    private Color getColor(int[] newColor) {
        Color color = null;
        try{
            color = new Color(newColor[0],newColor[1],newColor[2]);
        }catch (Exception e){
            return color;
        }
        return color;
    }
}
