package com.lumr.sbeam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lumr
 * @since 2019/9/16 下午11:27
 */
@Component
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfigure {

    private List<String> chain;

    public List<String> getChain() {
        return chain;
    }

    public void setChain(List<String> chain) {
        this.chain = chain;
    }
}
