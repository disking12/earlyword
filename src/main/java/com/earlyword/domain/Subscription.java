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
public class Subscription {
	private Long subscriptionId;
	private Long userId;
	private Long passId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int difficulty;
}
