package com.asiainfo.readinglist.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

//@ConfigurationProperties(prefix = "app.system",locations = "classpath:spring-data.yml")
public class AppSystemProperties {

    private Duration sessionTimeout = Duration.ofSeconds(30);
    private Duration readTimeout = Duration.ofMillis(1000);
    public Duration getSessionTimeout() {
    return this.sessionTimeout;
    }
    public void setSessionTimeout(Duration sessionTimeout) {
    this.sessionTimeout = sessionTimeout;
    }
    public Duration getReadTimeout() {
    return this.readTimeout;
    }
    public void setReadTimeout(Duration readTimeout) {
    this.readTimeout = readTimeout;
    }
}