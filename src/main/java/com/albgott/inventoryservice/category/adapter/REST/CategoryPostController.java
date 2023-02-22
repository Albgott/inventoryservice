package com.albgott.inventoryservice.category.adapter.REST;

import com.albgott.inventoryservice.category.application.create.CreateCategoryCommand;
import com.albgott.inventoryservice.category.application.create.CreateCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryPostController {
    private final CreateCategoryService createCategoryService;

    public CategoryPostController(CreateCategoryService createCategoryService) {
        this.createCategoryService = createCategoryService;
    }

    @PostMapping
    public ResponseEntity<String> doPost(@RequestBody Body body){
        createCategoryService.exec(
                new CreateCategoryCommand(
                        body.categoryId,body.categoryName, body.categoryDescription,
                        body.color, body.businessId
                )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private record Body(String businessId, String categoryId, String categoryName,
                        String categoryDescription, int[] color){};
}
