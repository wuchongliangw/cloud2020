package com.meamei.controller;

import com.meamei.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mm013
 * @create 2020-06-22 14:15:00
 * @description:
 */
@RestController
@RequestMapping("/consumer/payment/hystrix")
@Slf4j
@DefaultProperties(defaultFallback = "paymnet_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Long id) {
        return "我是消费者8010，对方支付系统繁忙请10秒钟后再试试或者自己运行出错请检查自己";
    }

    /**
     * 全局fallback方法
     *
     * @return
     */
    public String paymnet_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后重试， o(╥﹏╥)o";
    }
}
