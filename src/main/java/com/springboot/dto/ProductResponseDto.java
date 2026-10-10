package com.springboot.dto;

import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
public class ProductResponseDto {

private Long productNo;
    private String productName;
    private Long price;

    private Long inventory;

}
