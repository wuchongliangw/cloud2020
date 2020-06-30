package com.meamei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mm013
 * @create 2020-06-22 14:10:55
 * @description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrderHystrixMain8010 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8010.class, args);
    }
}
