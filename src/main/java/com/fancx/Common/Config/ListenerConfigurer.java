package com.fancx.Common.Config;

import com.fancx.Common.Web.Listener.SSHConnectionListener;
import com.fancx.Common.Util.SSHConnector;
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
