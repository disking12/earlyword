package com.earlyword.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.earlyword.controller.KakaoPayController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.earlyword.service.KakaoPayService;

@WebMvcTest(KakaoPayController.class)
class KakaoPayControllerTest {

	@MockBean
	KakaoPayService kakaoPayService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void 테스트_컨트롤러() throws Exception {
		mockMvc.perform(get("/payment/test"))
			.andExpect(status().isOk())
			.andDo(print());
	}

	@Test
	void 카카오_결제준비_컨트롤러() throws Exception {
		mockMvc.perform(post("/payment/ready")
			.param("item_name", "매일 영어 단어(기본)")
			.param("quantity", "1")
			.param("total_amount", "10000")
			.param("vat_amount", "1000")
			.param("partner_user_id", "test")
			.param("partner_order_id", "test")
			.param("tax_free_amount", "0"))
			.andExpect(status().isOk())
			.andDo(print());
	}

}