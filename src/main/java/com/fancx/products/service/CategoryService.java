package com.fancx.products.service;

import com.fancx.common.enums.Pagination;
import com.fancx.products.util.ProductModule;
import com.fancx.common.service.ResourceService;
import com.fancx.products.entity.CategoryEntity;
import com.fancx.products.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ResourceService resourceService;

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

    private void setLevelAndParentId(CategoryEntity category) {
        Integer[] nums = category.getHigherCategoryValue();
        if (nums.length == 0) {
            category.setLevel(1);
        } else {
            int parent_id = nums[nums.length - 1];
            category.setLevel(nums.length + 1);
            category.setParent_id(parent_id);
        }
    }

    public void editCategory(CategoryEntity category) {
        this.setLevelAndParentId(category);
        categoryMapper.editCategory(category);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {SQLException.class})
    public String addCategory(CategoryEntity category) {
        String UUID = resourceService.generateImageUUID(ProductModule.CATEGORY.getName());
        category.setAvatar(UUID);
        this.setLevelAndParentId(category);
        categoryMapper.addCategory(category);
        return UUID;
    }

    /**
     * 根据当前id得到一个从自己最大父节点到自己的name数组
     *
     * @param id
     * @return
     */
    public Map<String, Object> getHigherCategory(Integer id) {
        Map<String, Object> res = new HashMap<>();
        LinkedList<String> list1 = new LinkedList();//上级分类的String表示(前端showValue)
        LinkedList<Integer> list2 = new LinkedList();//前端higherCategoryValue
        StringBuilder sb = new StringBuilder();
        //这部分可以考虑优化
        Integer parent_id = categoryMapper.getParentIdById(id);
        while (parent_id != null) {
            list1.addFirst(categoryMapper.getNameById(parent_id));
            list2.addFirst(parent_id);
            parent_id = categoryMapper.getParentIdById(parent_id);
        }
        for (String str : list1) {
            sb.append(str);
            sb.append(" / ");
        }
        if (sb.length() != 0) {
            res.put("showValue", sb.substring(0, sb.length() - 3) + " （点击进行更改）");//去掉最后的" / "
        } else {
            res.put("showValue", "无上级分类 （点击进行更改）");
        }
        res.put("higherCategoryValue", list2.toArray(new Integer[list2.size()]));
        return res;
    }


    public List<CategoryEntity> getCategory(Integer parent_id, Integer page) {
        int start = Pagination.PAGE_SIZE.getPageSize() * (page - 1);
        return categoryMapper.getCategory(parent_id, start, Pagination.PAGE_SIZE.getPageSize());
    }

    public int getCategoryPageCount(Integer parent_id) {
        int count = categoryMapper.getCategoryPageCount(parent_id);
        int x = count / Pagination.PAGE_SIZE.getPageSize();
        int y = count % Pagination.PAGE_SIZE.getPageSize();
        int pageCount = x + (y == 0 ? 0 : 1);
        System.out.println(55);
        System.out.println(pageCount);
        return pageCount;//想上取整
    }

    public void deleteCategory(Integer id) {
        categoryMapper.deleCategory(id);
    }

    public CategoryEntity lookSuperior(Integer id) {
        return categoryMapper.lookSuperior(id);
    }


    public void changeStatus(Integer id, String status, boolean value) {
        categoryMapper.changeStatus(id, status, value);
    }
}
