package com.albgott.inventoryservice.category.adapter.REST;

import com.albgott.inventoryservice.category.application.modify.ModifyCategoryCommand;
import com.albgott.inventoryservice.category.application.modify.ModifyCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryPutController {

    private final ModifyCategoryService modifyCategoryService;

    public CategoryPutController(ModifyCategoryService modifyCategoryService) {
        this.modifyCategoryService = modifyCategoryService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> doPut(@PathVariable String id, @RequestBody Body body){
        modifyCategoryService.exec(new ModifyCategoryCommand(id,body.categoryName, body.categoryDescription, body.color));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private record Body(String categoryName, String categoryDescription, int[] color){}
}
