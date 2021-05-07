package com.yano.server;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.yano.common.http.Request;
import com.yano.common.http.Response;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author frank
 * @version 1.0
 * @date 2020-04-08 17:53
 */
public class RpcServerInboundHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(RpcServerInboundHandler.class);

    private final Map<String, Object> handle;

    public RpcServerInboundHandler(Map<String, Object> handle) {
        this.handle = handle;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Request request = (Request) msg;
        logger.info("request data {}", JSON.toJSONString(request));

        // jdk 反射调用
        Object bean = handle.get(request.getInterfaceName());
        Method method = bean.getClass().getMethod(request.getMethodName(), request.getParameterTypes());
        method.setAccessible(true);
        Object result = method.invoke(bean, request.getParameter());

        Response response = new Response();
        response.setRequestId(request.getRequestId());
        response.setResult(result);

        // client 接收到信息后主动关闭掉连接
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
