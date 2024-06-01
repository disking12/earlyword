package com.earlyword.controller;

import com.earlyword.domain.Payment;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.earlyword.dto.KakaoPay;
import com.earlyword.service.KakaoPayService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    @PostMapping("/ready")
    @ResponseBody
    public ResponseEntity readyKakaoPay(KakaoPay.ReadyRequest params) {
        kakaoPayService.readyKakaoPay(params);
		return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/success")
    @ResponseBody
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
}
