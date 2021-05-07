package com.yano;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author yano
 * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * @date 2021-05-07
 */
@SpringBootApplication
public class RpcServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RpcServerApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
