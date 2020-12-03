package com.atguigu.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName WebAllApplication
 * @Description:
 * @Author Hao
 * @Date 2020/12/2 13:54
 * @Version V1.0
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class WebAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAllApplication.class,args);
    }
}
