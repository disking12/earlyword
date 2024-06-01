package com.earlyword.mapper;

import com.earlyword.domain.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentMapperTest {

    @Autowired
    PaymentMapper paymentMapper;

    @Test
    void 결제_조회_테스트() {
        Payment payment = paymentMapper.findById(1L);
        System.out.println("payment = " + payment);
    }

}