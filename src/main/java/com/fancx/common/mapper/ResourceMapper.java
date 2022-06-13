package com.fancx.common.mapper;

import com.fancx.common.entity.ImageEntity;

public interface ResourceMapper {
    int updateAvatar(String tableName, ImageEntity avatar);

    ImageEntity selectImageByUUID(String tableName, String UUID);

    Integer insertImage(String UUID, String tableName);
}
