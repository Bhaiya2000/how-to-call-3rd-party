package dev.anand.productservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
public interface CategoryService {
    public String getAllCategories();
    public String getProductsInCategory( Long categoryId);

}
