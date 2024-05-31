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
	public KakaoPay.ReadyResponse readyKakaoPay(KakaoPay.ReadyRequest params, HttpSession session) {
		System.out.println("params = " + params);

		KakaoPay.ReadyResponse readyResponse = kakaoPayService.readyKakaoPay(params);

		session.setAttribute("tid", readyResponse.getTid());
		return readyResponse;
	}

	@GetMapping("/success")
	public KakaoPay.ApproveResponse approveKakaoPay(@RequestParam(name = "pg_token") String pgToken, HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("tid"));

		String tid = (String) request.getSession().getAttribute("tid");
		System.out.println("tid = " + tid);
		System.out.println("pgToken = " + pgToken);
		KakaoPay.ApproveRequest approveRequest = new KakaoPay.ApproveRequest();
		approveRequest.setTid(tid);
		approveRequest.setPg_token(pgToken);
		return kakaoPayService.approveKakaoPay(approveRequest);

	}

}
