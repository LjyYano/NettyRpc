package com.yano;

import com.yano.service.HelloService;
import com.yano.service.HiService;

/**
 * @author frank
 * @version 1.0
 * @date 2020-05-27 11:53
 */
public class RpcClientApplication {

    public static void main(String[] args) {
        HiService hiService = RpcProxy.create(HiService.class);
        String msg = hiService.hi("msg");
        System.out.println(msg);

        HelloService helloService = RpcProxy.create(HelloService.class);
        msg = helloService.hello("msg");
        System.out.println(msg);
    }
}
