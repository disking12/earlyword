package com.earlyword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class KakaoPayController {

	@GetMapping("/test")
	public String test() {
		return "test 데이터입니다";
	}

}
