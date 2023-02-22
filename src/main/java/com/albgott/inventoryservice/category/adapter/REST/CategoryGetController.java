package com.albgott.inventoryservice.category.adapter.REST;

import com.albgott.inventoryservice.category.DTO.CategoriesDTO;
import com.albgott.inventoryservice.category.DTO.CategoryDTO;
import com.albgott.inventoryservice.category.application.find.FindAllBusinessCategoriesQuery;
import com.albgott.inventoryservice.category.application.find.FindAllBusinessCategoriesService;
import com.albgott.inventoryservice.category.application.find.FindCategoryByIdQuery;
import com.albgott.inventoryservice.category.application.find.FindCategoryByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CategoryGetController {

    private final FindAllBusinessCategoriesService findAllBusinessCategories;
    private final FindCategoryByIdService findCategoryById;

    public CategoryGetController(FindAllBusinessCategoriesService findAllBusinessCategories,
                                 FindCategoryByIdService findCategoryById) {
        this.findAllBusinessCategories = findAllBusinessCategories;
        this.findCategoryById = findCategoryById;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable String id){
        CategoryDTO categoryDTO = findCategoryById.exec(
                new FindCategoryByIdQuery(id)
        );
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/categories/business/{id}")
    public ResponseEntity<CategoriesDTO> findAllFromBusiness(@PathVariable String id){
        CategoriesDTO categoriesDTO = findAllBusinessCategories.exec(
                new FindAllBusinessCategoriesQuery(id)
        );
        return ResponseEntity.ok(categoriesDTO);
    }
}
