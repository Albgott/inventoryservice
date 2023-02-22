package com.albgott.inventoryservice.category.DTO;

import com.albgott.inventoryservice.category.domain.model.Category;
import com.albgott.inventoryservice.shared.application.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class CategoriesDTO implements Response {
    private List<CategoryDTO> data = new ArrayList<>();

    public CategoriesDTO(List<Category> categories) {
        this.data = categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }
}
