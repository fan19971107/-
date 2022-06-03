package com.fancx.Common.Controller;

import com.fancx.Common.Entity.ImageEntity;
import com.fancx.Common.Result.CommonResultData;
import com.fancx.Common.Result.CommonResultUtil;
import com.fancx.Common.Service.ResourceService;
import com.fancx.Common.Util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理静态资源相关
 */
@RequestMapping("/resource")
@RestController
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    /**
     * 接受和存储前端发过来的商品分类图片
     *
     * @param avatarFile 图片文件
     * @param fileType   图片类型
     * @return
     * @throws IOException
     */
    @PostMapping("/setAvatar")
    CommonResultData setAvatar(@RequestParam("avatarFile") MultipartFile avatarFile, @RequestParam("fileType") String fileType) throws IOException {
        String UUID = UUIDUtil.getUUID();
        ImageEntity avatar = new ImageEntity(UUID, fileType, avatarFile.getInputStream());
        resourceService.putAvatar(avatar);
        return CommonResultUtil.success(UUID);
    }

    @GetMapping(value = "/getAvatar/{UUID}", produces = "image/jpeg;charset=UTF-8")
    public void getAvatar(@PathVariable(value = "UUID") String UUID, HttpServletResponse response) throws IOException {
        ImageEntity avatar = resourceService.getAvatar(UUID);
        BufferedOutputStream bufferedOutputStream = null;
        if (avatar == null) {
            avatar = resourceService.getAvatar("ImageNotFound");
        }
        response.setHeader("imageType", avatar.getType());
        byte[] data_input = avatar.getData_input();
        try {
            bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
            bufferedOutputStream.write(data_input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedOutputStream.close();
        }
    }

}
