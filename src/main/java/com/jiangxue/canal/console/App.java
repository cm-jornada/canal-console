package com.jiangxue.canal.console;

import com.jiangxue.canal.console.utils.StringSerializer;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ZkClient zkClient() {
        ZkClient zkClient = new ZkClient("172.16.150.60:2181");
        zkClient.setZkSerializer(new StringSerializer());
        return zkClient;
    }
}
