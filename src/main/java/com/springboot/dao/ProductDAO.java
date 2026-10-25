package com.springboot.dao;

import com.springboot.entity.Products;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductDAO {
    List<Products> selectProductsByName(String productName);

    Products insertProduct(Products products);
    Products selectProduct(Long ProductNo);
    Products updateProduct(Long ProductNo,String ProductName)throws Exception;
    void deleteProduct(Long ProductNo) throws Exception;



}
