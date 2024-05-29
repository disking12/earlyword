package com.earlyword.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SubscribeTest {

	@Test
	void 구독도메인_데이터_저장조회() {
		Subscribe subscribe = Subscribe.builder()
			.itemNumber(1L)
			.userId(1L)
			.level(1)
			.pass("기본")
			.build();
		System.out.println(subscribe);
		Assertions.assertThat(subscribe.getItemNumber()).isEqualTo(1L);
	}

}