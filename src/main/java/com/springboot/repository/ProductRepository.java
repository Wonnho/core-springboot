package com.springboot.repository;

import com.springboot.entity.Products;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Long> {
    List<Products> findByProductNameOrderByProductNoAsc(String productName);

    List<Products> findByProductName(String name, Sort sort);
}
