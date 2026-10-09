package com.springboot.service.Impl;

import com.springboot.dao.ProductDAO;
import com.springboot.dto.ProductDto;
import com.springboot.dto.ProductResponseDto;
import com.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long productNo) {
        return null;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductResponseDto changeProductName(Long productNo, String productName) throws Exception {
        return null;
    }

    @Override
    public void deleteProduct(Long productNo) throws Exception {

    }
}
