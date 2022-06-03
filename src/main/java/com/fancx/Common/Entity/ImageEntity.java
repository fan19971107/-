package com.fancx.Common.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.InputStream;
import java.sql.Blob;

@Data
public class ImageEntity {
    private Integer id;//主键
    private String UUID;//文件名称
    private String type;//图片类型(jpeg,png)
    private InputStream data;//输入二进制流
    private byte[] data_input;//从数据库获取图片

    public ImageEntity() {
    }
    public ImageEntity(String UUID, String type, InputStream data) {
        this.UUID = UUID;
        this.type = type;
        this.data = data;
    }
}
