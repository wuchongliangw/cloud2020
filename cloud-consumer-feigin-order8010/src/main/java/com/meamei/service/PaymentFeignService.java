package com.meamei.service;

import com.meamei.entity.Payment;
import com.meamei.entity.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mm013
 * @Date: 2020-06-21 10:59
 * @description:
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/find/{id}")
    RestResponse findOneById(@PathVariable("id") Long id);
}
