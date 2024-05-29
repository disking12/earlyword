package com.earlyword.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.earlyword.domain.Subscription;

@SpringBootTest
class SubscriptionMapperTest {

	@Autowired
	private SubscriptionMapper subscriptionMapper;

	@Test
	void 구독정보_조회() {
		Subscription subscription = subscriptionMapper.findById(1L);
		System.out.println("subscription = " + subscription);

		Assertions.assertThat(subscription.getUserId()).isEqualTo(1L);
	}
}