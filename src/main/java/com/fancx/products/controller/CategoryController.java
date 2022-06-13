package com.fancx.products.controller;

import com.fancx.common.result.CommonResultData;
import com.fancx.common.result.CommonResultUtil;
import com.fancx.products.entity.CategoryEntity;
import com.fancx.products.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getCategorySelector/{parent_id}")
    public CommonResultData getCategorySelector(@PathVariable(value = "parent_id") Integer parent_id) {
        List<Map<String, Object>> categorySelector = categoryService.getCategorySelector(parent_id);
        return CommonResultUtil.success(categorySelector);
    }

    @PostMapping("/addCategory")
    public CommonResultData addCategory(@RequestBody CategoryEntity category) {
        String avatarUUID = categoryService.addCategory(category);
        return CommonResultUtil.success(avatarUUID);//返回AvatarUUID
    }

    @GetMapping("/getHigherCategory/{id}")
    public CommonResultData getHigherCategory(@PathVariable("id") Integer id) {

        Map<String, Object> res = categoryService.getHigherCategory(id);
        return CommonResultUtil.success(res);
    }


    @GetMapping("/getCategory/{parent_id}/{page}")
    public CommonResultData getCategory(@PathVariable("parent_id") Integer parent_id, @PathVariable("page") Integer page) {
        List<CategoryEntity> categorys = categoryService.getCategory(parent_id, page);//page为第几页
        return CommonResultUtil.success(categorys);
    }

    @GetMapping("/getCategoryPageCount/{parent_id}")
    public CommonResultData getCategoryPageCount(@PathVariable("parent_id") Integer parent_id) {
        int count = categoryService.getCategoryPageCount(parent_id);
        return CommonResultUtil.success(count);
    }

    @GetMapping("/deleteCategory/{id}")
    public CommonResultData deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return CommonResultUtil.success();
    }

    @GetMapping("/lookSuperior/{id}")
    public CommonResultData lookSuperior(@PathVariable("id") Integer id) {
        CategoryEntity superior = categoryService.lookSuperior(id);
        return CommonResultUtil.success(superior);
    }

    @PostMapping("/editCategory")
    public CommonResultData editCategory(@RequestBody CategoryEntity category) {
        categoryService.editCategory(category);
        return CommonResultUtil.success();
    }

    @GetMapping("/changeStatus/{id}")
    public CommonResultData changeStatus(@PathVariable("id") Integer id,
                                         @RequestParam String status,
                                         @RequestParam boolean value) {
        categoryService.changeStatus(id, status, value);
        return CommonResultUtil.success();
    }

}
