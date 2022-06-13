package com.fancx.common.controller;

import com.fancx.common.entity.ImageEntity;
import com.fancx.common.result.CommonResultData;
import com.fancx.common.result.CommonResultUtil;
import com.fancx.common.service.ResourceService;
import com.fancx.common.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

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
    @PostMapping("/setAvatar/{table}/{avatarUUID}")
    CommonResultData setAvatar(@RequestParam("avatarFile") MultipartFile avatarFile,
                               @RequestParam("fileType") String fileType,
                               @PathVariable("table") String moduleName,//要插入的表名
                               @PathVariable("avatarUUID") String avatarUUID) throws IOException {
        System.out.println("##############");
        System.out.println(moduleName);
        System.out.println(avatarUUID);
        System.out.println(avatarUUID.getBytes(StandardCharsets.UTF_8));
        ImageEntity avatar = new ImageEntity(avatarUUID, fileType, avatarFile.getInputStream());
        resourceService.updateAvatar(moduleName, avatar);
        return CommonResultUtil.success();
    }

    @GetMapping(value = "/getAvatar/{table}/{UUID}", produces = "image/jpeg;charset=UTF-8")
    public void getAvatar(@PathVariable(value = "UUID") String UUID,
                          @PathVariable(value = "table") String moduleName,
                          HttpServletResponse response) throws IOException {
        ImageEntity avatar = resourceService.getAvatar(moduleName, UUID);
        BufferedOutputStream bufferedOutputStream = null;
        response.setHeader("imageType", "image/jpeg");
        if (avatar != null && avatar.getDataByte() != null) {
            try {
                bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
                bufferedOutputStream.write(avatar.getDataByte());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                bufferedOutputStream.close();
            }
        }
    }

}
