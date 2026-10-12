package com.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeProductNameDto {

    private Long productNo;
    private String productName;

    public ChangeProductNameDto(Long productNo, String productName) {
        this.productNo = productNo;
        this.productName = productName;
    }
}
