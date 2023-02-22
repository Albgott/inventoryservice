package com.albgott.inventoryservice.category.adapter.REST;

import com.albgott.inventoryservice.category.application.delete.DeleteCategoryCommand;
import com.albgott.inventoryservice.category.application.delete.DeleteCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
public class CategoryDeleteController {

    private final DeleteCategoryService deleteCategoryService;

    public CategoryDeleteController(DeleteCategoryService deleteCategoryService) {
        this.deleteCategoryService = deleteCategoryService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> doDelete(@PathVariable String id){
        deleteCategoryService.exec(new DeleteCategoryCommand(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
