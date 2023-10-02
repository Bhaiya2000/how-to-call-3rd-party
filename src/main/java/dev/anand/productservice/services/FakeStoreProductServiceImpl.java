package dev.anand.productservice.services;

import dev.anand.productservice.dtos.ProductDto;
import dev.anand.productservice.models.Category;
import dev.anand.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
   private RestTemplateBuilder restTemplateBuilder;

   public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
       this.restTemplateBuilder= restTemplateBuilder;
   }

    @Override
    public List<Product> getAllProducts() {
       RestTemplate restTemplate = restTemplateBuilder.build();
      ResponseEntity<ProductDto[]> l =  restTemplate.getForEntity(
               "https://fakestoreapi.com/products", ProductDto[].class
       );
      List<Product> answer = new ArrayList<>();

      for(ProductDto productDto: l.getBody())
      {
          Product product = new Product();
          product.setId(productDto.getId());
          product.setTitle(productDto.getTitle());
          product.setPrice(productDto.getPrice());
          product.setDescription(productDto.getDescription());
          Category category = new Category();
          category.setName(productDto.getCategory());
          product.setCategory(category);
          product.setImageUrl(productDto.getImage());
          answer.add(product);
      }

return answer;
//      for(Object object: l.getBody())
//      {
//          HashMap<String, Object> hm = (HashMap<String, Object>) object;
//          Product product = new Product();
//          product.setId(Long.valueOf((Integer)hm.get("id")));
//          product.setTitle((String)hm.get("title"));
//          product.setPrice(Double.valueOf( hm.get("price").toString()));
//          Category category = new Category();
//          category.setName((String)hm.get("category"));
//          product.setCategory(category);
//          product.setImageUrl((String) hm.get("image"));
//          answer.add(product);
//      }
//
    }
/*
Return a Product object with  all  the details of the fetched  product .
The ID of the category will be null but the name of the category shall be correct.


 */
    @Override
    public Product getSingleProduct(Long productID) {
       RestTemplate restTemplate = restTemplateBuilder.build(); // By doing this I got one REST Template Object
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class, productID);

       ProductDto productDto= response.getBody();

       Product product = new Product();
       product.setId(productDto.getId());
       product.setTitle(productDto.getTitle());
       product.setPrice(productDto.getPrice());
       product.setDescription(productDto.getDescription());
       Category category = new Category();
       category.setName(productDto.getCategory());
       product.setCategory(category);
       product.setImageUrl(productDto.getImage());

        return product;
//        if(response.getStatusCode().is2xxSuccessful())
//        {
//
//        }else {
//
//        }

    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
          ResponseEntity<ProductDto> response = restTemplate.postForEntity(
                  "https://fakestoreapi.com/products",product,
                   ProductDto.class
           );
        ProductDto productDto= response.getBody();

        Product product1 = new Product();
        product1.setId(productDto.getId());
        product1.setTitle(productDto.getTitle());
        product1.setPrice(productDto.getPrice());
        product1.setDescription(productDto.getDescription());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product1.setCategory(category);
        product1.setImageUrl(productDto.getImage());

        return product1;
    }

    @Override
    public Product updateProduct(Long productID, Product product) {
        return null;
    }

    @Override
    public boolean deletingProduct(Long productID) {
        return false;
    }
}
