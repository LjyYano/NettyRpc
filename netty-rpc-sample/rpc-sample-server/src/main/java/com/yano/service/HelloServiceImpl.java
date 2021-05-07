package com.yano.service;

import com.yano.common.annotation.RpcServer;


@RpcServer(cls = HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String msg) {
        return "hello echo: " + msg;
    }
}
