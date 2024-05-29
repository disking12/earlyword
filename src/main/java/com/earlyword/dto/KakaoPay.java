package com.earlyword.dto;

public class KakaoPay {

	/**
	 * 결제 준비 응답 DTO
	 */
	public static class ReadyResponse {
		private String tid;
		private String next_redirect_mobile_url;
		private String next_redirect_pc_url;
		private String created_at;
	}
}
