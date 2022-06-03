package com.fancx.Common.Service;

import com.fancx.Common.Entity.ImageEntity;
import com.fancx.Common.Exception.ImageUploadFailException;
import com.fancx.Common.Mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    ResourceMapper resourceMapper;

    public void putAvatar(ImageEntity avatar) {
        Integer i = resourceMapper.insertAvatar(avatar);
        if (i == null) {//插入失败
            throw new ImageUploadFailException();
        }
    }

    public ImageEntity getAvatar(String uuid) {
        ImageEntity avatar=resourceMapper.selectImageByUUID(uuid);
        return avatar;
    }
}
