package com.fancx.products.mapper;

import com.fancx.products.entity.CategoryEntity;

import java.util.List;

public interface CategoryMapper {

    List<CategoryEntity> getCategorySelector(Integer parent_id);

    Integer addCategory(CategoryEntity category);

    List<CategoryEntity> getCategory(Integer parent_id, Integer start, Integer pageSize);

    int getCategoryPageCount(Integer parent_id);

    void deleCategory(Integer id);

    CategoryEntity lookSuperior(Integer parent_id);

    void editCategory(CategoryEntity category);

    Integer getParentIdById(Integer id);

    String getNameById(Integer id);

    String getParentNameByName(String name);

    void changeStatus(Integer id, String status, boolean value);
}
