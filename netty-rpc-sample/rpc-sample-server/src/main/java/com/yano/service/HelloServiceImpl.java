package com.yano.service;

import com.yano.common.annotation.RpcServer;

/**
 * @author yano
 * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * @date 2021-05-07
 */
@RpcServer(cls = HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String msg) {
        return "hello echo: " + msg;
    }
}
