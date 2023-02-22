package com.albgott.inventoryservice.category.infrastructure;

import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.category.domain.model.Category;
import com.albgott.inventoryservice.category.domain.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JpaCategoryRepository repository;

    public CategoryRepositoryImpl(JpaCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(Category category) {
        repository.delete(category);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findByBusiness(Business business) {
        return repository.findByBusiness(business);
    }
}
