package com.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
@Setter
@Getter
@ToString
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
