package com.meamei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mm013
 * @Date: 2020-06-21 10:56
 * @description:
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain8010 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8010.class, args);
    }
}
