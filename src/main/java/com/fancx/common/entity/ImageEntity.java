package com.fancx.common.entity;

import lombok.Data;

import java.io.InputStream;

@Data
public class ImageEntity {
    private Integer id;//主键
    private String UUID;//文件名称
    private String type;//图片类型(jpeg,png)
    private InputStream dataStream;
    private byte[] dataByte;

    public ImageEntity() {
    }

    public ImageEntity(String UUID, String type, byte[] dataByte) {
        this.UUID = UUID;
        this.type = type;
        this.dataByte = dataByte;
    }

    public ImageEntity(String UUID, String type, InputStream inputStream) {
        this.UUID = UUID;
        this.type = type;
        this.dataStream = inputStream;
    }
}
