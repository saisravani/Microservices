package com.sravani.product_service.controller;

import com.sravani.product_service.dto.ProductRequestDto;
import com.sravani.product_service.dto.ProductResponseDto;
import com.sravani.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequestDto productRequestDto){
        productService.addProduct(productRequestDto);
        //productService.getProduct(product.getId());
        //return new ResponseEntity.ok("product added");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
        //productService.getProduct(product.getId());
        //return new ResponseEntity.ok("product added");
    }




}
