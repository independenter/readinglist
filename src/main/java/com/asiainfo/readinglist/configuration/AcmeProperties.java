package com.asiainfo.readinglist.configuration;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix="acme",locations = "classpath:spring-data.yml")
@Validated
public class AcmeProperties {
    private boolean enabled;

    @NotNull
    private InetAddress remoteAddress;
    private final Map<String, String> map = new HashMap<>();
    @Valid
    private final Security security = new Security();
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled=enabled; }
    public InetAddress getRemoteAddress() { return remoteAddress; }
    public void setRemoteAddress(InetAddress remoteAddress) { this.remoteAddress=remoteAddress; }
    public Security getSecurity() { return this.security; }

    public Map<String, String> getMap() {
        return map;
    }

    public static class Security {
        @NotEmpty
        private String username;
        private String password;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username=username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public List<String> getRoles() { return roles; }
        public void setRoles(List<String> roles) { this.roles = roles; }
    }
}