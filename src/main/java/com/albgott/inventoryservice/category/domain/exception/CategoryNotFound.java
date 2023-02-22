package com.albgott.inventoryservice.category.domain.exception;

import com.albgott.inventoryservice.shared.domain.exception.NotFoundExeption;

public class CategoryNotFound extends NotFoundExeption {
    public CategoryNotFound(String categoryId) {
        super("CATEGORY_NOT_FOUND", String.format("Could not find category with id '%s'",categoryId));
    }
}
