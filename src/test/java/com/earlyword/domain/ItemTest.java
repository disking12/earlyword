package com.earlyword.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void 상품도메인_데이터_저장조회() {
		Item item = Item.builder()
			.itemName("영어 단어(초급")
			.itemPrice(10000)
			.build();
		System.out.println(item);
		Assertions.assertThat(item.getItemPrice()).isEqualTo(10000);
	}

}