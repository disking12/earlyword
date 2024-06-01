package com.earlyword.mapper;

import com.earlyword.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    Payment findById(Long userId);
}
