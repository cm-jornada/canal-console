package com.jiangxue.canal.console;


import com.jiangxue.canal.console.utils.ZookeeperPathUtils;
import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CanalTest {

    @Test
    public void getChildren() {
        ZkClient zkClient = new ZkClient("172.16.150.60:2181");
        List<String> destinationList = zkClient.getChildren(ZookeeperPathUtils.DESTINATION_ROOT_NODE);
        System.out.println(destinationList);
        for (String str : destinationList) {
            List<String> children = zkClient.getChildren(ZookeeperPathUtils.DESTINATION_ROOT_NODE + ZookeeperPathUtils.ZOOKEEPER_SEPARATOR + str);
            System.out.println(str + ":" + children);
            System.out.println("xi hu…………………………………… ok");
        }
    }
}
