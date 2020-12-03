package com.atguigu.gmall.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.lang.model.type.ArrayType;

/**
 * @ClassName ItemApiApplication
 * @Description:
 * @Author Hao
 * @Date 2020/12/3 9:52
 * @Version V1.0
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients("com.atguigu.gmall")
public class ItemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemApiApplication.class, args);
    }
}
