package com.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuchongliang
 * @description
 * @date 2022-01-18
 */
@FeignClient(value = "nacos-user-service", contextId = "userClient")
public interface UserClient {

    String PREFIX = "/userClient/";

    @GetMapping(PREFIX + "/get")
    String get(@RequestParam("name") String name);
}
