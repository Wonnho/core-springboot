package com.springboot.test.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.entity.Products;
import com.springboot.entity.QProducts;
import com.springboot.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static com.springboot.entity.QProducts.products;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {

        Products product1 = new Products();
        product1.setProductName("pen");
        product1.setPrice(1000L);
        product1.setInventory(100L);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Products product2 = new Products();
        product2.setProductName("pen");
        product2.setPrice(2500L);
        product2.setInventory(90L);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Products product3 = new Products();
        product3.setProductName("pen");
        product3.setPrice(2000L);
        product3.setInventory(120L);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Products saveProduct1 = productRepository.save(product1);
        Products saveProduct2 = productRepository.save(product2);
        Products saveProduct3 = productRepository.save(product3);


        // sort Product by Product name
        productRepository.findByProductName("pen", Sort.by(Sort.Order.asc("price")));

        // paging

        Page<Products> productPage = productRepository.findByProductName("pen", PageRequest.of(0, 2));
        System.out.println(productPage.getContent());

//        assertThat(productPage.getContent())
//                .extracting(Products::getPrice)
//                .containsExactly(1000L, 2000L);
//
//        assertThat(productPage.getTotalElements())
//                .isEqualTo(3);
    }

    @PersistenceContext
    EntityManager entityManager;
    @Test
    public void queryDSLTest() {

        JPAQuery<Products> qeury = new JPAQuery(entityManager);
        QProducts qProducts = products;
        List<Products> productList = qeury
                .from(qProducts)
                .where(qProducts.productName.eq("pen"))
                .orderBy(qProducts.price.asc())
                .fetch();

        for (Products products : productList) {
            System.out.println("====================");
            System.out.println();
            System.out.println("Product Number:" + products.getProductNo());
            System.out.println("Product Name:" + products.getProductName());
            System.out.println("Product Price:" + products.getPrice());
            System.out.println("Prodcut Inventory:" + products.getInventory());
            System.out.println();
            System.out.println("====================");

        }
    }
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    public void queryDslTest4() {
        QProducts qProducts = products;

     List<String>  productList=jpaQueryFactory
                .select(qProducts.productName)
                .from(qProducts)
                .where(qProducts.productName.eq("pen"))
                .orderBy(qProducts.price.asc())
                .fetch();

        for(String products: productList) {
            System.out.println("====================");
            System.out.println("Product Number:" + products);
            System.out.println("====================");

        }
    }
}
