package com.yano.common.zookeeper;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.util.CollectionUtils;

/**
 * @author liujiayu03 <liujiayu03@kuaishou.com>
 * Created on 2021-05-07
 */
public class ZooKeeperOp {

    private static final String zkAddress = "localhost:2181";
    private static final ZkClient zkClient = new ZkClient(zkAddress);

    public static void register(String serviceName, String serviceAddress) {
        if (!zkClient.exists(serviceName)) {
            zkClient.createPersistent(serviceName);
        }
        zkClient.createEphemeral(serviceName + "/" + serviceAddress);
        System.out.printf("create node %s \n", serviceName + "/" + serviceAddress);
    }

    public static String discover(String serviceName) {
        List<String> children = zkClient.getChildren(serviceName);
        if (CollectionUtils.isEmpty(children)) {
            return "";
        }
        return children.get(ThreadLocalRandom.current().nextInt(children.size()));
    }
}
