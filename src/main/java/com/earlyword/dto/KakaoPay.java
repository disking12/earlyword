package com.earlyword.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class KakaoPay {

	/**
	 * 카카오페이 결제 준비 응답 DTO
	 */
	@Getter	@Setter	@ToString
	public static class ReadyResponse {
		private String tid;
		private String next_redirect_mobile_url;
		private String next_redirect_pc_url;
		private String created_at;
	}

	/**
	 * 카카오페이 결제 준비 요청 DTO
	 */
	@Getter	@Setter	@ToString
	public static class ReadyRequest {
		private String partner_order_id;
		private String parter_user_id;
		private String item_name;
		private String quantity;
		private String total_amount;
		private String vat_amount;
		private String tax_free_amount;
	}

	@Getter	@Setter	@ToString
	public static class ApproveResponse {
		private String aid;
		private String tid;
		private String cid;
		private String sid;
		private String partner_order_id;
		private String partner_user_id;
		private String payment_method_type;
		private Amount amount;
		private String item_name;
		private String item_code;
		private int quantity;
		private String created_at;
		private String approved_at;
		private String payload;
	}

	@Getter	@Setter	@ToString
	public static class ApproveRequest {
		private String tid;
		private String partner_order_id;
		private String partner_user_id;
		private String pg_token;
	}

	@Getter	@Setter	@ToString
	public static class Amount {
		private int total;
		private int tax_free;
		private int tax;
		private int point;
		private int discount;
		private int green_deposit;
	}
}
