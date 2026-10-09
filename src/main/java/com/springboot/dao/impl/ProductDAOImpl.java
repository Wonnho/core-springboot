package com.springboot.dao.impl;

import com.springboot.dao.ProductDAO;
import com.springboot.entity.Products;
import com.springboot.repository.ProductRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Products insertProduct(Products products) {
        Products saveProduct=productRepository.save(products);
        return saveProduct;
    }

    @Override
    public Products selectProduct(Long productNo) {
     Products  product=productRepository.findById(productNo)
             .orElseThrow(() -> new IllegalArgumentException("No such product"));

        return product;
    }

    @Transactional
    @Override
    public Products updateProduct(Long productNo, String productName) throws Exception {
     Products selectedProduct=productRepository.findById(productNo)
//             .orElseThrow(()->new IllegalArgumentException("No such Product : ") + ProductNo));
            .orElseThrow(() -> new IllegalArgumentException("No such product: " + productNo));
        selectedProduct.setProductName(productName);
       // selectedProduct.setPrice();

        return selectedProduct;
    }

    @Override
    public void deleteProduct(Long productNo) throws Exception {
      Products  selectedProduct=productRepository.findById(productNo)
              .orElseThrow(() -> new IllegalArgumentException("No such product: " + productNo));

         productRepository.delete(selectedProduct);
    }
}
