package com.springboot.service.Impl;

import com.springboot.dao.ProductDAO;
import com.springboot.dto.ProductDto;
import com.springboot.dto.ProductResponseDto;
import com.springboot.entity.Products;
import com.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
      Products product=productDAO.selectProduct(productNo);
      ProductResponseDto response=new ProductResponseDto();

        response.setProductNo(product.getProductNo());
        response.setProductName(product.getProductName());
        response.setPrice(product.getPrice());
        response.setInventory(product.getInventory());

        return response;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Products product=new Products();
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setInventory(productDto.getInventory());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());


        Products saved=productDAO.insertProduct(product);

    ProductResponseDto   response=new ProductResponseDto();
        response.setProductNo(product.getProductNo());
        response.setProductName(product.getProductName());
        response.setPrice(product.getPrice());
        response.setInventory(product.getInventory());

        return response;
    }

    @Override
    public ProductResponseDto changeProductName(Long productNo, String productName) throws Exception {
         Products  update= productDAO.updateProduct(productNo,productName);

         ProductResponseDto productResponseDto=new ProductResponseDto();

         productResponseDto.setProductNo(update.getProductNo());
         productResponseDto.setProductName(update.getProductName());
         productResponseDto.setPrice(update.getPrice());
         productResponseDto.setInventory(update.getInventory());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long productNo) throws Exception {
                      productDAO.deleteProduct(productNo);
    }
}
