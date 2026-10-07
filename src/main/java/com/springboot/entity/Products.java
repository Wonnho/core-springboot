package com.springboot.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Products {

    private Long productNo;

    private String productName;

    private Long price;

    private Long inventory;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
