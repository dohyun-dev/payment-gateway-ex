package com.dohyundev.core.payment.domain.model.info.card;

import com.dohyundev.core.payment.domain.enums.CardInterestPayer;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public record CardInstallmentInfo(
        int installmentPlanMonths,              // 할부 개월 수
        boolean isInterestFree,                 // 무이자 여부
        @Enumerated(EnumType.STRING)
        CardInterestPayer interestPayer         // 수수료 부담 주체
) {}
