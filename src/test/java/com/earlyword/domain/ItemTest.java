package com.earlyword.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void 상품도메인_데이터_저장조회() {
		Item item = Item.builder()
			.itemName("매일 영어 단어")
			.build();
		System.out.println(item);
		Assertions.assertThat(item.getItemName()).isEqualTo("매일 영어 단어");
	}

}