package dev.anand.productservice.services;

import dev.anand.productservice.dtos.ProductDto;
import dev.anand.productservice.models.Category;
import dev.anand.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

     Product getSingleProduct( Long productID);
    Product addNewProduct( ProductDto product);
    Product updateProduct(Long productID, Product product);
    boolean deletingProduct(Long productID );
}
