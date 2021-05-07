package com.yano.service;

import com.yano.common.annotation.RpcServer;

/**
 * @author yano
 * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * @date 2021-05-07
 */
@RpcServer(cls = HiService.class)
public class HiServiceImpl implements HiService {

    public String hi(String msg) {
        return "hi echo: " + msg;
    }
}
