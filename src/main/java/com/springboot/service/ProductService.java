package com.springboot.service;

import com.springboot.dto.ProductDto;
import com.springboot.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long productNo);

    ProductResponseDto saveProduct(ProductDto productDto);
    ProductResponseDto changeProductName(Long productNo,String productName) throws Exception;

    void deleteProduct(Long productNo) throws Exception;

}
