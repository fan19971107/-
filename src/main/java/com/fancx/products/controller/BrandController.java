package com.fancx.products.controller;

import com.fancx.common.result.CommonResultData;
import com.fancx.common.result.CommonResultUtil;
import com.fancx.products.entity.BrandEntity;
import com.fancx.products.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;


    @PostMapping("/addBrand")
    public CommonResultData addBrand(@RequestBody BrandEntity brand) {
        String avatarUUID = brandService.addBrand(brand);
        return CommonResultUtil.success(avatarUUID);
    }

    @GetMapping("/getPageCount")
    public CommonResultData getCategoryPageCount() {
        int count = brandService.getPageCount();
        return CommonResultUtil.success(count);
    }

    @GetMapping("/getBrand/{page}")
    public CommonResultData getBrand(@PathVariable("page") Integer page) {
        List<BrandEntity> brands = brandService.getBrand(page);//page为第几页
        return CommonResultUtil.success(brands);
    }

    @PostMapping("/edit")
    public CommonResultData edit(@RequestBody BrandEntity brand) {
        brandService.edit(brand);
        return CommonResultUtil.success();
    }

    @GetMapping("/delete/{id}")
    public CommonResultData deleteCategory(@PathVariable("id") Integer id) {
        brandService.delete(id);
        return CommonResultUtil.success();
    }
}
