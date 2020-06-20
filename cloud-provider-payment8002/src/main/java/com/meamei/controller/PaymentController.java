package com.meamei.controller;

import com.meamei.service.PaymentService;
import com.meamei.entity.Payment;
import com.meamei.entity.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author mm013
 * @create 2020-06-19 11:43:08
 * @description:
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public RestResponse create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {
            return RestResponse.success("插入数据成功, serverPort: " + serverPort);
        } else {
            return RestResponse.error("插入数据失败");
        }
    }

    @GetMapping("/find/{id}")
    public RestResponse findOneById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return RestResponse.success(payment + ", serverPort: " + serverPort);
    }
}
