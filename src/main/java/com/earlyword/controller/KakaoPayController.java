package com.earlyword.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		KakaoPay.ReadyResponse readyResponse = kakaoPayService.readyKakaoPay(params);
		return readyResponse;
	}

	@GetMapping("/success")
	public KakaoPay.ApproveResponse approveKakaoPay(@RequestParam(name = "pg_token") String pgToken) {
		KakaoPay.ApproveRequest approveRequest = new KakaoPay.ApproveRequest();
		return kakaoPayService.approveKakaoPay(approveRequest);

	}

}
