package com.yano;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.yano.common.annotation.RpcServer;
import com.yano.server.NettyServer;

/**
 * @author frank
 * @version 1.0
 * @date 2020-05-26 15:15
 */
@Component
public class NettyApplicationContextAware implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(NettyApplicationContextAware.class);

    @Value("${zk.address}")
    private String zookeeperAddress;

    @Value("${zk.port}")
    private int zookeeperPort;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> rpcBeanMap = new HashMap<>();
        for (Object object : applicationContext.getBeansWithAnnotation(RpcServer.class).values()) {
            rpcBeanMap.put("/" + object.getClass().getAnnotation(RpcServer.class).cls().getName(), object);
        }
        try {
            NettyServer.start(zookeeperAddress, zookeeperPort, rpcBeanMap);
        } catch (Exception e) {
            logger.error("register error !", e);
        }
    }
}
