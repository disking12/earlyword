package com.earlyword.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.earlyword.dto.KakaoPay;

@Service
public class KakaoPayService {

	private static final String READY_URL = "https://kapi.kakao.com/v1/payment/ready";
	private static final String APPROVE_URL = "https://kapi.kakao.com/v1/payment/approve";

	private static final String SUCCESS_URL = "http://localhost:8080/payment/success";
	private static final String CANCEL_URL = "http://localhost:8080/payment/cancel";
	private static final String FAIL_URL = "http://localhost:8080/payment/fail";
	@Value("${kakaopay.cid}")
	private String CID;
	@Value("${kakaopay.adminkey}")
	private String ADMIN_KEY;

	/**
	 * 카카오페이 결제 준비 요청
	 */
	public KakaoPay.ReadyResponse readyKakaoPay(KakaoPay.ReadyRequest readyRequest) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", CID);
		params.add("partner_order_id", readyRequest.getPartner_order_id());
		params.add("partner_user_id", readyRequest.getParter_user_id());
		params.add("item_name", readyRequest.getItem_name());
		params.add("quantity", readyRequest.getQuantity());
		params.add("total_amount", readyRequest.getTotal_amount());
		params.add("vat_amount", readyRequest.getVat_amount());
		params.add("tax_free_amount", readyRequest.getTax_free_amount());
		params.add("approval_url", SUCCESS_URL);
		params.add("cancel_url", CANCEL_URL);
		params.add("fail_url", FAIL_URL);

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, this.setHeaders());

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.postForObject(READY_URL, requestEntity, KakaoPay.ReadyResponse.class);
	}

	/**
	 * 카카오페이 결제 승인 요청
	 */
	public KakaoPay.ApproveResponse approveKakaoPay(KakaoPay.ApproveRequest approveRequest) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", CID);
		params.add("tid", approveRequest.getTid());
		params.add("partner_order_id", approveRequest.getPartner_order_id());
		params.add("partner_user_id", approveRequest.getPartner_user_id());
		params.add("pg_token", approveRequest.getPg_token());

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, this.setHeaders());

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.postForObject(APPROVE_URL, requestEntity, KakaoPay.ApproveResponse.class);
	}

	/**
	 * HTTP 헤더 생성
	 */
	private HttpHeaders setHeaders() {
		String auth = "KakaoAK " + ADMIN_KEY;

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", auth);
		httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		return httpHeaders;
	}
}
