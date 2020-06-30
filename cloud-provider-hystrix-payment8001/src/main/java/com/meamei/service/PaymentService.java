package com.meamei.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author mm013
 * @create 2020-06-22 11:03:03
 * @description:
 */
@Service
public class PaymentService {

    /**
     * 正常访问方法
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Long id) {
        return "线程池 ：" + Thread.currentThread().getName() + " paymentInfo_OK，id: " + id + "\t" +"O(∩_∩)O哈哈~";
    }

    // =============  服务降级  ================
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Long id) {
        // 暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int age = 10/0;
        return "线程池 ：" + Thread.currentThread().getName() + " paymentInfo_TimeOut，id: " + id + "\t" + "o(╥﹏╥)o  耗时3秒钟";
    }

    public String paymentInfo_TimeOutHandler(Long id) {
        return "线程池 ：" + Thread.currentThread().getName() + " 系统繁忙，请稍后再试，id: " + id + "\t" + "o(╥﹏╥)o";
    }


    // ================== 服务熔断 ===============
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("id不能是负数");
        }
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号: " + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id) {
        return "id 不能是负数，请稍后再试....";
    }


}
