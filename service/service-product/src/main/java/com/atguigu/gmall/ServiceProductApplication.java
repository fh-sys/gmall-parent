package com.atguigu.gmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ServiceProductApplication
 * @Description:
 * @Author Hao
 * @Date 2020/11/27 19:21
 * @Version V1.0
 **/
@MapperScan("com.atguigu.gmall")
@SpringBootApplication
public class ServiceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class,args);
    }
}
