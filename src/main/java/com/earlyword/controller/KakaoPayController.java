package com.earlyword.controller;

import com.earlyword.domain.Payment;
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
        return kakaoPayService.readyKakaoPay(params);
	}

	@GetMapping("/success")
	public KakaoPay.ApproveResponse approveKakaoPay(@RequestParam(name = "pg_token") String pgToken) {

		//현재 로그인 기능이 없어 "test" 계정을 사용
		//해당 계정에 대한 결제 정보 조회 (카카오결제번호, 주문번호, 회원PK ..)
		Payment payment = kakaoPayService.getPaymentInfo(1L);

		KakaoPay.ApproveRequest approveRequest = new KakaoPay.ApproveRequest();
		approveRequest.setTid(payment.getTid());
		approveRequest.setPartner_order_id(payment.getOrderId());
		approveRequest.setPartner_user_id("test");
		approveRequest.setPg_token(pgToken);
		return kakaoPayService.approveKakaoPay(approveRequest);

	}

}
