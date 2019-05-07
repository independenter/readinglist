package com.asiainfo.readinglist.service;

import com.asiainfo.readinglist.configuration.AcmeProperties;
import com.asiainfo.readinglist.configuration.Config;
import org.eclipse.jetty.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

@Service
public class MyService {
    private final AcmeProperties properties;
    private final Config config;

    @Autowired
    public MyService(AcmeProperties properties,Config config) {
        this.properties = properties;
        this.config = config;
    }
    //...
    @PostConstruct
    public void openConnection() {
        Server server = new Server(new InetSocketAddress(this.properties.getRemoteAddress(),8088));
    }
}