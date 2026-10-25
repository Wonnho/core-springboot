package com.springboot.controller;

import com.springboot.dto.ChangeProductNameDto;
import com.springboot.dto.ProductDto;
import com.springboot.dto.ProductResponseDto;
import com.springboot.entity.Products;
import com.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
   private ProductService productService;

    @GetMapping("/api/search")
    public List<ProductResponseDto> retrieveByName(
            @RequestParam String productName
    ) {
        return productService.getProductsByName(productName);
    }


    @GetMapping("/api/{productNo}")
    public ProductResponseDto retrieve(@PathVariable("productNo") Long productNo) {
     ProductResponseDto products=productService.getProduct(productNo);

        return products;
    }
    @Transactional
    @PostMapping("/api")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
     ProductResponseDto  created=productService.saveProduct(productDto);

      return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @Transactional
    @PutMapping("/api")
    public  ResponseEntity<ProductResponseDto> putProduct(
            @RequestBody ChangeProductNameDto dto) throws Exception {
    ProductResponseDto  changed=productService.changeProductName(dto.getProductNo(),dto.getProductName());

    return ResponseEntity.status(HttpStatus.OK).body(changed);
    }

    @Transactional
    @DeleteMapping("/api")
       public void deleteProduct(
            @RequestParam("productNo") Long productNo) throws Exception {
                   productService.deleteProduct(productNo);

    }

}
