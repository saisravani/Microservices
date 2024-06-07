package com.sravani.product_service.service;

import com.sravani.product_service.dto.ProductRequestDto;
import com.sravani.product_service.dto.ProductResponseDto;
import com.sravani.product_service.model.Product;
import com.sravani.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepo;
    public void addProduct(ProductRequestDto productRequestDto) {

        Product product= Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice()).build();
        productRepo.save(product);

        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(this::mapToProductResponseDto).toList();
    }

    private ProductResponseDto mapToProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
