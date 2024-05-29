package com.earlyword.service;

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

	private static final String readyUrl = "https://kapi.kakao.com/v1/payment/ready";
	private static final String approvalUrl = "http://localhost:8080/payment/success";
	private static final String cancelUrl = "http://localhost:8080/payment/cancel";
	private static final String failUrl = "http://localhost:8080/payment/fail";
	@Value("${kakaopay.cid}")
	private String cid;
	@Value("${kakaopay.adminkey}")
	private String adminKey;

	/**
	 * 카카오페이 결제 준비 요청
	 */
	public KakaoPay.ReadyResponse kakaoPayReady(KakaoPay.ReadyRequest readyRequest) {
		MultiValueMap<String, String> params = setParams(readyRequest);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, this.setHeaders());

		RestTemplate restTemplate = new RestTemplate();
		KakaoPay.ReadyResponse readyResponse = restTemplate.postForObject(readyUrl, requestEntity,
			KakaoPay.ReadyResponse.class);

		return readyResponse;
	}

	/**
	 * HTTP 헤더 생성
	 */
	private HttpHeaders setHeaders() {
		String auth = "KakaoAK " + adminKey;

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", auth);
		httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		return httpHeaders;
	}

	/**
	 * HTTP 데이터 생성
	 */
	private MultiValueMap<String, String> setParams(KakaoPay.ReadyRequest readyRequest) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", cid);
		params.add("partner_order_id", readyRequest.getPartner_order_id());
		params.add("partner_user_id", readyRequest.getParter_user_id());
		params.add("item_name", readyRequest.getItem_name());
		params.add("quantity", readyRequest.getQuantity());
		params.add("total_amount", readyRequest.getTotal_amount());
		params.add("vat_amount", readyRequest.getVat_amount());
		params.add("tax_free_amount", readyRequest.getTax_free_amount());
		params.add("approval_url", approvalUrl);
		params.add("cancel_url", cancelUrl);
		params.add("fail_url", failUrl);

		return params;
	}
}
