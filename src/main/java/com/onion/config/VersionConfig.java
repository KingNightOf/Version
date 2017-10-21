package com.onion.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by OnionMac on 2017/10/18.
 */
@ConfigurationProperties(prefix = "config")
@Component
public class VersionConfig {

    /**
     * json文件的地址
     */
    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
