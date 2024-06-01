package com.earlyword.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Payment {

    private String tid;
    private String orderId;
    private int userId;
    private int passId;
    private int succYn;
}
