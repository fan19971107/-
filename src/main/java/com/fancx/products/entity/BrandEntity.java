package com.fancx.products.entity;

import lombok.Data;

@Data
public class BrandEntity {
    private Integer id;
    private String brandName;
    private Character brandInitials;
    private String avatarUUID;
    private Integer order;
}
