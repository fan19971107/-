package com.fancx.Products.Service;

import com.fancx.Common.Entity.ImageEntity;
import com.fancx.Common.Enum.Pagination;
import com.fancx.Products.Entity.CategoryEntity;
import com.fancx.Products.Mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;


    public List<Map<String, Object>> getCategorySelector(Integer parent_id) {
        List<CategoryEntity> categorySelectors = categoryMapper.getCategorySelector(parent_id);
        List<Map<String, Object>> list = new LinkedList<>();
        for (CategoryEntity selector : categorySelectors) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", String.valueOf(selector.getId()));
            map.put("label", selector.getName());
            map.put("leaf", selector.getLevel() >= 2);
            list.add(map);
        }
        return list;
    }

    public void addCategory(CategoryEntity category) {
        Integer[] nums = category.getHigherCategoryValue();
        if (nums.length == 0) {
            category.setLevel(1);
        } else {
            int parent_id = nums[nums.length - 1];
            category.setLevel(nums.length + 1);
            category.setParent_id(parent_id);
        }
        categoryMapper.addCategory(category);
    }

    public List<CategoryEntity> getCategory(Integer parent_id, Integer page) {
        int start = Pagination.Category_PageSize.getPageSize() * (page - 1);
        return categoryMapper.getCategory(parent_id, start, Pagination.Category_PageSize.getPageSize());
    }

    public int getCategoryPageCount(Integer parent_id) {
        int count = categoryMapper.getCategoryPageCount(parent_id);
        int x = count / Pagination.Category_PageSize.getPageSize();
        int y = count % Pagination.Category_PageSize.getPageSize();
        return x + (y == 0 ? 0 : 1);//想上取整
    }
}
