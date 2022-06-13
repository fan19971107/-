package com.fancx.common.service;

import com.fancx.common.entity.ImageEntity;
import com.fancx.common.exception.ImageUploadFailException;
import com.fancx.common.mapper.ResourceMapper;
import com.fancx.common.util.MapperUtil;
import com.fancx.common.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ResourceService {
    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    MapperUtil mapperUtil;

    public void updateAvatar(String moduleName, ImageEntity avatar) throws IOException {
        String tableName = mapperUtil.moduleNameToTableName(moduleName);
        Integer i = resourceMapper.updateAvatar(tableName, avatar);
        if (i == null) {//插入失败
            throw new ImageUploadFailException();
        }
    }

    public ImageEntity getAvatar(String moduleName, String UUID) {
        String tableName = mapperUtil.moduleNameToTableName(moduleName);
        ImageEntity avatar = resourceMapper.selectImageByUUID(tableName, UUID);
        return avatar;
    }

    public String generateImageUUID(String moduleName) {
        String UUID = UUIDUtil.getUUID();
        System.out.println(35);
        System.out.println(moduleName);
        ;
        String tableName = mapperUtil.moduleNameToTableName(moduleName);
        resourceMapper.insertImage(UUID, tableName);
        return UUID;
    }
}
