package com.yano.common.http;

import lombok.Data;

/**
 * @author yano
 * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * @date 2021-05-07
 */
@Data
public class Response {

    private String requestId;
    private Object result;

}
