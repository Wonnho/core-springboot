package com.springboot.dao;

import com.springboot.entity.Products;

import java.time.LocalDateTime;

public interface ProductDAO {

    Products insertProduct(Products products);
    Products selectProduct(Long ProductNo);
    Products updateProduct(Long ProductNo,String ProductName)throws Exception;
    void deleteProduct(Long ProductNo) throws Exception;

}
