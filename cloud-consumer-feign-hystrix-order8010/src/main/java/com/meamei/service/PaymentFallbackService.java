package com.meamei.service;

import org.springframework.stereotype.Component;

/**
 * @author mm013
 * @create 2020-06-22 16:01:44
 * @description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "----PaymentFallbackService fall back-paymentInfoOk ";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "----PaymentFallbackService fall back-paymentInfo timeout";
    }
}
