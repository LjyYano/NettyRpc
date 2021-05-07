package com.yano;

import com.yano.service.HelloService;
import com.yano.service.HiService;

/**
 * @author yano
 * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * <p>
 * * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * @date 2021-05-07
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
