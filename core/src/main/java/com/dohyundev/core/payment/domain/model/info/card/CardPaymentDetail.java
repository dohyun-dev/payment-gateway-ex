package com.dohyundev.core.payment.domain.model.info.card;

import com.dohyundev.core.payment.domain.model.info.PaymentDetail;
import com.dohyundev.core.payment.domain.enums.CardAcquireStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("CARD")
@Getter
public class CardPaymentDetail extends PaymentDetail {
    @Embedded
    private CardInfo cardInfo;

    @Embedded
    private CardInstallmentInfo installmentDetail;

    @Embedded
    private CardPointInfo cardPointInfo;

    @Enumerated(EnumType.STRING)
    private CardAcquireStatus acquireStatus = CardAcquireStatus.READY;

    public CardPaymentDetail(CardInfo cardInfo, CardInstallmentInfo installmentDetail, CardPointInfo cardPointInfo, CardAcquireStatus acquireStatus, long amount) {
        super(amount);
        this.cardInfo = cardInfo;
        this.installmentDetail = installmentDetail;
        this.cardPointInfo = cardPointInfo;
        this.acquireStatus = acquireStatus;
    }

    public void changeAcquireStatus(CardAcquireStatus status) {
        this.acquireStatus = status;
    }
}
