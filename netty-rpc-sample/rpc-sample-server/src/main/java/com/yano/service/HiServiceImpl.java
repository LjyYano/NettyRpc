package com.yano.service;

import com.yano.common.annotation.RpcServer;

/**
 * @author frank
 * @version 1.0
 * @date 2020-05-26 15:09
 */
@RpcServer(cls = HiService.class)
public class HiServiceImpl implements HiService {

    public String hi(String msg) {
        return "hi echo: " + msg;
    }
}
