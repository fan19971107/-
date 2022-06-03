package com.fancx.Common.Web.Listener;

import com.fancx.Common.Util.SSHConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SSHConnectionListener implements ServletContextListener {
    private SSHConnector sshConnector;

    public SSHConnectionListener(SSHConnector sshConnector) {
        super();
        this.sshConnector = sshConnector;
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // 建立连接
        System.out.println("Context initialized ...!");
        try {
            sshConnector.SSHConnection();
            System.out.println("成功建立SSH连接!");
        } catch (Throwable e) {
            System.out.println("SSH连接失败！");
            e.printStackTrace(); // error connecting SSH server
        }
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // 断开连接
        System.out.println("Context destroyed ... !\n\n\n");
        try {
            sshConnector.closeSSH(); // disconnect
            System.out.println("成功断开SSH连接!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("断开SSH连接出错！");
        }
    }
}