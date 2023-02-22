package com.albgott.inventoryservice.category.domain.repository;

import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.category.domain.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    void save(Category category);
    void delete(Category category);
    void delete(UUID id);
    Optional<Category> findById(UUID id);
    List<Category> findByBusiness(Business business);
}
