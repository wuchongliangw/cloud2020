package com.nacos.admin.controller;

import com.nacos.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuchongliang
 * @description
 * @date 2022-01-18
 */
@RestController
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/api/user/get")
    public String get(@RequestParam("name") String name) {
        return userClient.get(name);
    }
}
