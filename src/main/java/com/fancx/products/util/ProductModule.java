package com.fancx.products.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductModule {
    CATEGORY("Category"),
    BRAND("Brand");

    String name;
}
