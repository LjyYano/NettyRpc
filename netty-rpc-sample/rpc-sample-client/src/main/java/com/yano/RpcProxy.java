package com.yano;

import java.util.UUID;

import com.yano.common.http.Request;
import com.yano.common.http.Response;

import net.sf.cglib.proxy.Proxy;

/**
 * @author frank
 * @version 1.0
 * @date 2020-05-27 11:54
 */
public class RpcProxy {

    public static <T> T create(final Class<?> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class<?>[] {cls}, (o, method, objects) -> {

            Request request = new Request();
            request.setInterfaceName("/" + cls.getName());
            request.setRequestId(UUID.randomUUID().toString());
            request.setParameter(objects);
            request.setMethodName(method.getName());
            request.setParameterTypes(method.getParameterTypes());

            Response response = new NettyClient().client(request);
            return response.getResult();
        });
    }
}
