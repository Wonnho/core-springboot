package com.springboot.dto;

import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ProductDto {
    private String productName;
    private Long price;

    private Long inventory;


}
