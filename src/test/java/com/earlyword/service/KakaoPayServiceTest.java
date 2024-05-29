package com.earlyword.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.earlyword.dto.KakaoPay;

@SpringBootTest
class KakaoPayServiceTest {

	@Autowired
	private KakaoPayService kakaoPayService;

	@Test
	void 카카오페이_결제요청() {
		KakaoPay.ReadyRequest readyRequest = new KakaoPay.ReadyRequest();
		readyRequest.setItem_name("영어 단어(초급)");
		readyRequest.setQuantity("1");
		readyRequest.setTotal_amount("10000");
		readyRequest.setVat_amount("1000");
		readyRequest.setParter_user_id("test");
		readyRequest.setPartner_order_id("test");
		readyRequest.setTax_free_amount("0");

		KakaoPay.ReadyResponse readyResponse = kakaoPayService.kakaoPayReady(readyRequest);
		System.out.println("readyResponse = " + readyResponse);

		Assertions.assertThat(readyResponse.getTid()).isNotEmpty();
	}

}