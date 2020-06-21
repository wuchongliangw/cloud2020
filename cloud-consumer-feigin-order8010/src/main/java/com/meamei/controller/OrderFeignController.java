package com.meamei.controller;

import com.meamei.entity.RestResponse;
import com.meamei.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mm013
 * @Date: 2020-06-21 11:04
 * @description:
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/find/{id}")
    public RestResponse getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.findOneById(id);
    }
}
