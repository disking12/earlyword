package com.earlyword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earlyword.dto.KakaoPay;
import com.earlyword.service.KakaoPayService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController {

	private final KakaoPayService kakaoPayService;

	@GetMapping("/test")
	public String test() {
		return "test 데이터입니다";
	}

	@PostMapping("/ready")
	public KakaoPay.ReadyResponse readyKakaoPay(KakaoPay.ReadyRequest params) {
		System.out.println("params = " + params);
		return kakaoPayService.readyKakaoPay(params);
	}

}
