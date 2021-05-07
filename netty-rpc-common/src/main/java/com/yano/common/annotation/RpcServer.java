package com.yano.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * @author frank
 * @version 1.0
 * @date 2020-05-26 14:47
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Component
public @interface RpcServer {

    /**
     * 接口类, 用以接口注册
     */
    Class<?> cls();

}
