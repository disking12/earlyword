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

	@Test
	void 카카오페이_승인요청() {

		KakaoPay.ApproveRequest approveRequest = new KakaoPay.ApproveRequest();

		approveRequest.setPartner_order_id("test");
		approveRequest.setPartner_user_id("test");
		approveRequest.setTid("T656eda4257c75a5308d");
		approveRequest.setPg_token("3409a327cc85f75f2022");

		KakaoPay.ApproveResponse approveResponse = kakaoPayService.kakaoPayApprove(approveRequest);
		System.out.println("approveResponse = " + approveResponse);
	}
}