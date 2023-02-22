package com.albgott.inventoryservice.category.DTO;

import com.albgott.inventoryservice.category.domain.model.Category;
import com.albgott.inventoryservice.shared.application.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryDTO implements Response {
    private String id;
    private String name;
    private String color;
    private String description;
    private String businessId;

    public CategoryDTO(Category category){
        this.id = category.id();
        this.name = category.name();
        this.color = category.color();
        this.description = category.description();
        this.businessId = category.businessId();
    }

}
