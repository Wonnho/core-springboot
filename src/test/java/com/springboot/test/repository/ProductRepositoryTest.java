package com.springboot.test.repository;

import com.springboot.entity.Products;
import com.springboot.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {

        Products product1=new Products();
        product1.setProductName("pen");
        product1.setPrice(1000L);
        product1.setInventory(100L);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Products product2=new Products();
        product2.setProductName("pen");
        product2.setPrice(2500L);
        product2.setInventory(90L);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Products product3=new Products();
        product3.setProductName("pen");
        product3.setPrice(2000L);
        product3.setInventory(120L);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());


        productRepository.findByProductName("Pen", Sort.by(Sort.Order.asc("price")));

    }
}
