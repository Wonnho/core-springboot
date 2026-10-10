package com.springboot.controller;

import com.springboot.dto.ProductResponseDto;
import com.springboot.entity.Products;
import com.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
   private ProductService productService;

    //          //retrieve all products

//    @GetMapping("/api")
//    public List<ProductResponseDto> retrieve() {
//        Products products=productService.retrieveAll();
//
//        return ProductResponseDto;
//    }

    @GetMapping("/api/{productNo}")
    public ProductResponseDto retrieve(@PathVariable("productNo") Long productNo) {
     ProductResponseDto products=productService.getProduct(productNo);

        return products;
    }
}
