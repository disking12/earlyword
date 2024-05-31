package com.earlyword.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class Payment {

    private String tid;
    private String orderId;
    private String userId;
    private String passId;g
}
