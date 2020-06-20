package com.meamei.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.meamei.entity.Payment;
import com.meamei.entity.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author mm013
 * @create 2020-06-19 14:23:53
 * @description:
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public RestResponse create(Payment payment) {
        MultiValueMap<String, Object> packageParams = new LinkedMultiValueMap<>();
        packageParams.add("serial", payment.getSerial());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity entity = new HttpEntity<>(packageParams, httpHeaders);
        JSONObject result = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", entity, JSONObject.class).getBody();
        return RestResponse.success(result.get("data"));
    }

    @GetMapping("/find/{id}")
    public RestResponse find(@PathVariable("id") Long id) {
        JSONObject object = restTemplate.getForObject(PAYMENT_URL + "/payment/find/" + id, JSONObject.class);
        return RestResponse.success(object.get("data"));
    }
}
