package com.fancx.admin.mapper;

import com.fancx.admin.entity.AdminEntity;

public interface AdminMapper {

    Integer selectIdByUsername(String username);

    Integer insertAdmin(AdminEntity adminEntity);

    Integer selectIdByLoginInfo(String username, String password);

    AdminEntity selectAdminByUsername(String username);
}
