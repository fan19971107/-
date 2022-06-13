package com.fancx.common.util;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//由于我们的数据库在阿里云服务器，所以需要配置SSH连接
@Data
@Component
@ConfigurationProperties(prefix = "fancx.ssh")
public class SSHConnector {
    String user;
    // 服务器登录名
    String password;
    // 登陆密码
    String host;
    //服务器公网IP
    int port;
    // 跳板机ssh开放的接口   默认端口 22
    int local_port_mysql;
    int local_port_Redis;
    // 这个是本地的端口，很重要！！！选取一个没有占用的port即可
    String remote_host ;
    // 要访问的mysql所在的host    服务器局域网IP（127.0.0.1也行）
    int remote_port_mysql;
    int remote_port_Redis;
    // 服务器上数据库端口号
    Session session = null;

    //建立SSH连接
    public void SSHConnection() throws Exception {
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(local_port_mysql, remote_host, remote_port_mysql);
            session.setPortForwardingL(local_port_Redis, remote_host, remote_port_Redis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //断开SSH连接
    public void closeSSH() throws Exception {
        this.session.disconnect();
    }

}