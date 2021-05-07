package com.yano.common.http;

import lombok.Data;

/**
 * @author frank
 * @version 1.0
 * @date 2020-04-08 17:04
 */
@Data
public class Request {

    private String requestId;
    private String interfaceName;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object parameter[];

}
