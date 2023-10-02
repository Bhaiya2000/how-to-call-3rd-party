package dev.anand.productservice.controllers;

import dev.anand.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/products/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping()
     public String getAllCategories()
     {

         return "Getting all categories";
     }
     @GetMapping("/{categoryID}")
     public String getProductsInCategory(@PathVariable("categoryId") Long categoryId)
     {
         return "Get products in category";
     }


}
