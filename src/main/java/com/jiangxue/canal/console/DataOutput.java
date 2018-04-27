package com.jiangxue.canal.console;

import com.alibaba.fastjson.JSONObject;
import com.jiangxue.canal.console.utils.ZookeeperPathUtils;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DataOutput {

    @Resource
    private ZkClient zkClient;

    @ResponseBody
    @RequestMapping("getRoot")
    public List<String> getRoot() {
        return zkClient.getChildren(ZookeeperPathUtils.DESTINATION_ROOT_NODE);
    }

    @ResponseBody
    @RequestMapping("getChildren")
    public List<String> getChildren(HttpServletRequest request) {
        String path = request.getParameter("path");
        String fullPath = ZookeeperPathUtils.DESTINATION_ROOT_NODE + ZookeeperPathUtils.ZOOKEEPER_SEPARATOR + path;
        List<String> childrenList = zkClient.getChildren(fullPath);
        if (CollectionUtils.isEmpty(childrenList)) {
            String str = zkClient.readData(fullPath);
            childrenList.add(str);
        }
        return childrenList;
    }

}
