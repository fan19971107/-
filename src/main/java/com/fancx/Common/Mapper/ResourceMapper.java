package com.fancx.Common.Mapper;

import com.fancx.Common.Entity.ImageEntity;

public interface ResourceMapper {
    int insertAvatar(ImageEntity avatar);

    ImageEntity selectImageByUUID(String uuid);
}
