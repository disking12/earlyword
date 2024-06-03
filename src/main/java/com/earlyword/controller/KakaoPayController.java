package com.earlyword.controller;

import com.earlyword.domain.Payment;
import com.earlyword.dto.KakaoPay;
import com.earlyword.service.KakaoPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    @PostMapping("/ready")
    public KakaoPay.ReadyResponse readyKakaoPay(KakaoPay.ReadyRequest params) {
        System.out.println("params = " + params);
        return kakaoPayService.readyKakaoPay(params);
    }

    @GetMapping("/success")
    public KakaoPay.ApproveResponse approveKakaoPay(@RequestParam(name = "pg_token") String pgToken) {
        //현재 로그인 기능이 없어 "test" 계정을 사용
        Payment payment = kakaoPayService.getPaymentInfo(1L);

        KakaoPay.ApproveRequest approveRequest = new KakaoPay.ApproveRequest();
        approveRequest.setTid(payment.getTid());
        approveRequest.setPartner_order_id(payment.getOrderId());
        approveRequest.setPartner_user_id("test");
        approveRequest.setPg_token(pgToken);

        return kakaoPayService.approveKakaoPay(approveRequest);
    }

	@GetMapping("/fail")
	public String fail() {
		return "fail";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "cancel";
	}
}
