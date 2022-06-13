package com.fancx.admin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AdminEntity implements Serializable {
    Integer id;
    String username;
    String password;
    String nickname;
    Integer status;
    Date loginDate;
    String icon;
}
