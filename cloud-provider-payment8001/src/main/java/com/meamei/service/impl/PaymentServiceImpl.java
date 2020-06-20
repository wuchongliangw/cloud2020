package com.meamei.service.impl;

import com.meamei.service.PaymentService;
import com.meamei.dao.PaymentDao;
import com.meamei.entity.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mm013
 * @create 2020-06-19 11:40:05
 * @description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
