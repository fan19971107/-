package com.fancx.admin.service;

import com.fancx.admin.entity.AdminEntity;
import com.fancx.admin.exception.AdminFailMessageException;
import com.fancx.admin.mapper.AdminMapper;
import com.fancx.admin.result.AdminResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;


    public boolean checkUsername(String username) {
        Integer id = adminMapper.selectIdByUsername(username);
        if (id == null)
            //可以使用
            return true;
        return false;
    }


    public boolean register(AdminEntity adminEntity) {
        Integer num = adminMapper.insertAdmin(adminEntity);
        if (num == 0)
            return false;
        return true;
    }


    public void checkLogin(String username, String password) {
        Integer id = adminMapper.selectIdByLoginInfo(username, password);
        if (id == null) {
            throw new AdminFailMessageException(AdminResultCode.LOGIN_FAILED);
        }
    }


    public AdminEntity getAdminInfo(String username) {
        return adminMapper.selectAdminByUsername(username);
    }
}
