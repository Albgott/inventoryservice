package com.albgott.inventoryservice.category.infrastructure;

import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.category.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category, UUID> {
    List<Category> findByBusiness(Business business);
}
