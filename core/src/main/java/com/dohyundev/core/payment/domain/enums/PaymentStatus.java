package com.dohyundev.core.payment.domain.enums;

public enum PaymentStatus {
    READY,  // 결제 대기
    IN_PROGRESS,    // 결제
    DONE,   // 승인
    CANCELED,   // 결제 취소
    ABORTED,    // 실패
//    EXPIRED //  유효기간 만료 거래 취소
}
