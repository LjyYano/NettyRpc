package com.yano.common.serialize;

import java.util.List;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * @author yano
 * GitHub 项目： https://github.com/LjyYano/Thinking_in_Java_MindMapping
 * @date 2021-05-07
 */
public class RpcDecoder extends MessageToMessageDecoder<ByteBuf> {

    private final Class<?> genericClass;

    public RpcDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) {
        if (msg.readableBytes() < 4) {
            return;
        }
        msg.markReaderIndex();
        int dataLength = msg.readInt();
        if (msg.readableBytes() < dataLength) {
            msg.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        msg.readBytes(data);

        out.add(JSON.parseObject(data, genericClass));
    }
}
