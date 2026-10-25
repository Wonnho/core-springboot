package com.springboot.repository;

import com.springboot.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Long> {
    List<Products> findByProductNameOrderByProductNoAsc(String productName);

    //Sort product by Product Name
//    @Query("select p from Products as p where p.productName=?1")
//    List<Products> findByProductName(String name, Sort sort);

    @Query("select p from Products as p where p.productName=:name")
    List<Products> findByProductName(@Param("name") String name, Sort sort);

    Page<Products> findByProductName(String name, Pageable pageable);

}
