package com.earlyword.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class Subscribe {

	private Long userId;
	private Long itemNumber;
	private int level;
	private String pass;
	private LocalDateTime subscribeDate;
	private LocalDateTime cancelDate;
}
