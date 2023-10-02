package dev.anand.productservice.controllers;

import dev.anand.productservice.dtos.ProductDto;
import dev.anand.productservice.models.Product;
import dev.anand.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
      @GetMapping()
      public List<Product> getAllProducts()
      {
          return productService.getAllProducts();
      }
      @GetMapping("/{productID}")
      public ResponseEntity<Product> getSingleProduct(@PathVariable("productID") Long productID)
      {
//           GetSingleProductResponseDto responseDto = new GetSingleProductResponseDto();
//           responseDto.setProduct(
//                   productService.getSingleProduct(productID)
//           );
//          return responseDto;

          MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
          headers.add(
                  "auth-token", "noaccess4uheyhey"
          );


          ResponseEntity<Product> respone = new  ResponseEntity(
                  productService.getSingleProduct(productID),
                  HttpStatus.OK
          );
          return respone;
      }

      @PostMapping()
      public ResponseEntity<Product> addNewProduct( @RequestBody ProductDto product)
      {
            Product newProduct = productService.addNewProduct(
                    product
            );
            ResponseEntity<Product> response = new ResponseEntity<>(newProduct,HttpStatus.OK);
          return response;
      }
      @PutMapping("/{productID}")
      public String updateProduct(@PathVariable("productID") long productID)
      {
          return "Updating product with ID: "+productID ;
      }
     @DeleteMapping("/{productID}")
      public String deletingProduct(@PathVariable("productID") Long productID )
      {
          return "Deleting a product with id :" + productID;
      }
}
