package com.fancx.common.config;

import com.fancx.common.web.listener.SSHConnectionListener;
import com.fancx.common.util.SSHConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfigurer {
    @Autowired
    SSHConnector sshConnector;
    @Bean
    public ServletListenerRegistrationBean<SSHConnectionListener> setSSHConnectionListener() {
        ServletListenerRegistrationBean<SSHConnectionListener> servletListenerRegistrationBean =
                new ServletListenerRegistrationBean<>(new SSHConnectionListener(sshConnector));
        return servletListenerRegistrationBean;
    }
}
