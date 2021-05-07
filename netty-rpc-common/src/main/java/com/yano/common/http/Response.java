package com.yano.common.http;

import lombok.Data;

/**
 * @author frank
 * @version 1.0
 * @date 2020-04-08 17:05
 */
@Data
public class Response {

    private String requestId;
    private Object result;

}
