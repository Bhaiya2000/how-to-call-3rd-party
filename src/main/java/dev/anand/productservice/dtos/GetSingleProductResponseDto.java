package dev.anand.productservice.dtos;

import dev.anand.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
