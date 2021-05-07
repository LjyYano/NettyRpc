package com.yano.common.serialize;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author yano
 * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * @date 2021-05-07
 */
public class RpcEncoder extends MessageToByteEncoder {

    private final Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) {
        if (genericClass.isInstance(msg)) {
            byte[] data = JSON.toJSONBytes(msg);
            out.writeInt(data.length);
            out.writeBytes(data);
        }
    }
}