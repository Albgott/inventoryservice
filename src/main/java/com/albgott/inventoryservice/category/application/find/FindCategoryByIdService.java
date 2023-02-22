package com.albgott.inventoryservice.category.application.find;

import com.albgott.inventoryservice.category.DTO.CategoryDTO;
import com.albgott.inventoryservice.category.domain.exception.CategoryNotFound;
import com.albgott.inventoryservice.category.domain.model.Category;
import com.albgott.inventoryservice.category.domain.repository.CategoryRepository;
import com.albgott.inventoryservice.shared.application.QueryUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class FindCategoryByIdService implements QueryUseCase<FindCategoryByIdQuery, CategoryDTO> {

    private final CategoryRepository categoryRepository;

    public FindCategoryByIdService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO exec(FindCategoryByIdQuery query) {
        Category category = categoryRepository.findById(UUID.fromString(query.categoryId()))
                .orElseThrow(() -> new CategoryNotFound(query.categoryId()));
        return new CategoryDTO(category);
    }
}
