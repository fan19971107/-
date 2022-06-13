package com.fancx.products.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryEntity {
    private Integer id;
    private Integer parent_id;
    private Integer[] higherCategoryValue;
    @JsonProperty("categoryName")
    private String name;
    private Integer level;
    @JsonProperty("navigationBar")
    private Boolean nav_status;
    @JsonProperty("display")
    private Boolean show_status;
    @JsonProperty("order")
    private Integer sort;
    @JsonProperty("avatarUUID")
    private String avatar;
    private String keywords;
    private String description;
}
