package com.earlyword.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class KakaoPayControllerTest {

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
		ResultActions resultActions = mockMvc.perform(post("/payment/ready")
				.param("item_name", "매일 영어 단어(기본)")
				.param("quantity", "1")
				.param("total_amount", "10000")
				.param("vat_amount", "1000")
				.param("partner_user_id", "test")
				.param("partner_order_id", "test")
				.param("tax_free_amount", "0")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED));

		resultActions.andExpect(status().isOk())
				.andDo(print())
				.andDo(log());
	}

}