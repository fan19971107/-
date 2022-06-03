package com.fancx.Admin.Mapper;

import com.fancx.Admin.Entity.AdminEntity;

public interface AdminMapper {

    Integer selectIdByUsername(String username);

    Integer insertAdmin(AdminEntity adminEntity);

    Integer selectIdByLoginInfo(String username, String password);

    AdminEntity selectAdminByUsername(String username);
}
