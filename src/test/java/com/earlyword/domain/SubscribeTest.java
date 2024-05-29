package com.earlyword.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SubscribeTest {

	@Test
	void 구독도메인_데이터_저장조회() {
		Subscription subscription = Subscription.builder()
			.subscriptionId(1L)
			.userId(1L)
			.passId(1L)
			.difficulty(1)
			.build();
		System.out.println(subscription);
		Assertions.assertThat(subscription.getSubscriptionId()).isEqualTo(1L);
	}

}