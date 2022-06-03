package com.fancx.Products.Controller;

import com.fancx.Common.Entity.ImageEntity;
import com.fancx.Common.Result.CommonResultData;
import com.fancx.Common.Result.CommonResultUtil;
import com.fancx.Common.Util.UUIDUtil;
import com.fancx.Products.Entity.CategoryEntity;
import com.fancx.Products.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

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
        categoryService.addCategory(category);
        return CommonResultUtil.success();
    }
    @GetMapping("/getCategory/{parent_id}/{page}")
    public CommonResultData getCategory(@PathVariable("parent_id")Integer parent_id,@PathVariable("page") Integer page){
        List<CategoryEntity> categorys= categoryService.getCategory(parent_id,page);//page为第几页
        return CommonResultUtil.success(categorys);
    }
    @GetMapping("getCategoryPageCount/{parent_id}")
    public CommonResultData getCategoryPageCount(@PathVariable("parent_id")Integer parent_id){
        int count=categoryService.getCategoryPageCount(parent_id);
        return CommonResultUtil.success(count);
    }
}
