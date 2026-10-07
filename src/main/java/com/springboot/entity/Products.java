package com.springboot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNo;


    private String productName;

    private Long price;

    private Long inventory;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
