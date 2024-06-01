package com.earlyword.mapper;

import com.earlyword.domain.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentMapperTest {

    @Autowired
    PaymentMapper paymentMapper;

    @Test
    void 결제_정보_조회_테스트() {
        Payment payment = paymentMapper.findById(1L);
        System.out.println("payment = " + payment);
    }

    @Test
    void 결제_정보_저장_테스트() {
        Payment payment = Payment.builder()
                .tid("1234")
                .orderId("1234")
                .userId(1L)
                .passId(1L)
                .succYn(null)
                .build();
        int result = paymentMapper.save(payment);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 결제_정보_업데이트_테스트() {
        Payment payment = Payment.builder()
                .tid("T65ad07e29fd342c671f")
                .succYn(1L)
                .build();
        int result = paymentMapper.update(payment);
        Assertions.assertThat(result).isEqualTo(1);
    }

}