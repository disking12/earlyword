package com.earlyword.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.earlyword.domain.Subscription;

@Mapper
public interface SubscriptionMapper {

	Subscription findById(Long id);
}
