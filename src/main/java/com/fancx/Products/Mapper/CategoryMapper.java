package com.fancx.Products.Mapper;

import com.fancx.Common.Entity.ImageEntity;
import com.fancx.Products.Entity.CategoryEntity;

import java.util.List;

public interface CategoryMapper {

    List<CategoryEntity> getCategorySelector(Integer parent_id);

    Integer addCategory(CategoryEntity category);

    List<CategoryEntity> getCategory(Integer parent_id, Integer start, Integer pageSize);

    int getCategoryPageCount(Integer parent_id);
}
