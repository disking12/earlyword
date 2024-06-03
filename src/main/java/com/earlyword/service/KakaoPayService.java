package com.earlyword.service;

import com.earlyword.domain.Payment;
import com.earlyword.dto.KakaoPay;
import com.earlyword.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KakaoPayService {

    private final PaymentMapper paymentMapper;
    private final RestTemplate restTemplate;

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
        KakaoPay.ReadyResponse readyResponse = null;

        //주문번호 생성
        String partnerOrderId = UUID.randomUUID().toString();
        readyRequest.setPartner_order_id(partnerOrderId);

        //HTTP 요청 데이터 생성
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(
                setReadyParams(readyRequest),
                this.setHeaders()
        );

        try {
            //카카오페이 결제 준비 API 호출
            readyResponse = restTemplate.postForObject(
                    READY_URL,
                    requestEntity,
                    KakaoPay.ReadyResponse.class
            );

            //결제 정보 저장
            if (!readyResponse.getTid().isEmpty()) {
                paymentMapper.save(Payment.builder()
                        .tid(readyResponse.getTid())
                        .userId(1L)
                        .passId(1L)
                        .orderId(partnerOrderId)
                        .build()
                );
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        System.out.println("readyResponse = " + readyResponse);

        return readyResponse;
    }

    /**
     * 카카오페이 결제 승인 요청
     */
    public KakaoPay.ApproveResponse approveKakaoPay(KakaoPay.ApproveRequest approveRequest) {
        KakaoPay.ApproveResponse approveResponse = null;

        //HTTP 요청 데이터 생성
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(
                setApproveParams(approveRequest),
                this.setHeaders()
        );

        try {
            //카카오페이 결제 승인 API 호출
            approveResponse = restTemplate.postForObject(
                    APPROVE_URL,
                    requestEntity,
                    KakaoPay.ApproveResponse.class
            );
            System.out.println("approveResponse = " + approveResponse);

            //결제 성공 업데이트
            if (!approveResponse.getTid().isEmpty()) {
                paymentMapper.update(Payment.builder()
                        .tid(approveResponse.getTid())
                        .succYn(1L)
                        .build()
                );
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                System.out.println(e.getMessage());

                //결제 실패 업데이트
                paymentMapper.update(Payment.builder()
                        .tid(approveResponse.getTid())
                        .succYn(0L)
                        .build()
                );
                throw e;
            }
        }
        return approveResponse;
    }

    /**
     * 결제 정보 조회 (결제 승인 요청시 필요한 데이터 get)
     */
    public Payment getPaymentInfo(Long userId) {
        return paymentMapper.findById(userId);
    }

    /**
     * 카카오페이 결제 준비 HTTP 파라미터 설정
     */
    private MultiValueMap<String, String> setReadyParams(KakaoPay.ReadyRequest readyRequest) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", CID);
        params.add("approval_url", SUCCESS_URL);
        params.add("cancel_url", CANCEL_URL);
        params.add("fail_url", FAIL_URL);
        params.add("partner_order_id", readyRequest.getPartner_order_id());
        params.add("partner_user_id", readyRequest.getPartner_user_id());
        params.add("item_name", readyRequest.getItem_name());
        params.add("quantity", readyRequest.getQuantity());
        params.add("total_amount", readyRequest.getTotal_amount());
        params.add("vat_amount", readyRequest.getVat_amount());
        params.add("tax_free_amount", readyRequest.getTax_free_amount());
        return params;
    }

    /**
     * 카카오페이 결제 승인 HTTP 파라미터 설정
     */
    private MultiValueMap<String, String> setApproveParams(KakaoPay.ApproveRequest approveRequest) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", CID);
        params.add("tid", approveRequest.getTid());
        params.add("partner_order_id", approveRequest.getPartner_order_id());
        params.add("partner_user_id", approveRequest.getPartner_user_id());
        params.add("pg_token", approveRequest.getPg_token());

        return params;
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
