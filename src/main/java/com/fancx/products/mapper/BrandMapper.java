package com.fancx.products.mapper;

import com.fancx.products.entity.BrandEntity;

import java.util.List;

public interface BrandMapper {
    public Integer addBrand(BrandEntity brand);

    Integer getPageCount();

    List<BrandEntity> getBrand(int start, Integer pageSize);

    void edit(BrandEntity brand);

    void delete(Integer id);
}
