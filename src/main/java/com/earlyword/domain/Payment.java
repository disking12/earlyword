package com.earlyword.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Payment {

    private String tid;
    private String orderId;
    private Long userId;
    private Long passId;
    private Long succYn;
    private LocalDateTime paymentDate;
}
