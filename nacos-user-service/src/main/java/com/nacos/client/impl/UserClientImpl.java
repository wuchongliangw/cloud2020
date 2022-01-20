package com.nacos.client.impl;

import com.nacos.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuchongliang
 * @description
 * @date 2022-01-18
 */
@RestController
public class UserClientImpl implements UserClient {

    @Override
    public String get(String name) {
        return "hello " + name;
    }
}
