package com.fancx.products.service;

import com.fancx.common.enums.Pagination;
import com.fancx.common.util.MapperUtil;
import com.fancx.products.mapper.BrandMapper;
import com.fancx.products.util.ProductModule;
import com.fancx.common.service.ResourceService;
import com.fancx.products.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    ResourceService resourceService;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    MapperUtil mapperUtil;

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {SQLException.class})
    public String addBrand(BrandEntity brand) {
        String UUID = resourceService.generateImageUUID(ProductModule.BRAND.getName());
        brand.setAvatarUUID(UUID);
        brandMapper.addBrand(brand);
        return UUID;
    }

    public int getPageCount() {
        int count = brandMapper.getPageCount();
        int pageCount = mapperUtil.computePageCount(count);
        return pageCount;//想上取整
    }

    public List<BrandEntity> getBrand(Integer page) {
        int start = Pagination.PAGE_SIZE.getPageSize() * (page - 1);
        return brandMapper.getBrand(start, Pagination.PAGE_SIZE.getPageSize());
    }

    public void edit(BrandEntity brand) {
        brandMapper.edit(brand);
    }

    public void delete(Integer id) {
        brandMapper.delete(id);
    }
}
