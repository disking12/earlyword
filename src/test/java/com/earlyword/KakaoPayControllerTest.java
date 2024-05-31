package com.earlyword;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(KakaoPayController.class)
class KakaoPayControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void 테스트_컨트롤러() throws Exception {
		mockMvc.perform(get("/payment/test"))
			.andExpect(status().isOk())
			.andDo(print());
	}

}