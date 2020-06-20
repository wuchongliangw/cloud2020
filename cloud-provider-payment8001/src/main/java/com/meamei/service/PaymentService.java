package com.meamei.service;

import com.meamei.entity.Payment;

/**
 * @author mm013
 * @create 2020-06-19 11:39:52
 * @description:
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
