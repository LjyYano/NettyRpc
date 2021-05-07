package com.yano;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author frank
 * @version 1.0
 * @date 2020-05-26 15:13
 */
@SpringBootApplication
public class RpcServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RpcServerApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
