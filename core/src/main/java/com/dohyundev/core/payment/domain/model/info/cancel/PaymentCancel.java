package com.dohyundev.core.payment.domain.model.info.cancel;

import com.dohyundev.core.payment.domain.enums.PaymentCancelStatus;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Getter
public abstract class PaymentCancel {
    private final PaymentCancelStatus status;
    private final long cancelAmount;
    private final LocalDateTime canceledAt;

    protected PaymentCancel(PaymentCancelStatus status, long cancelAmount) {
        this.status = status;
        this.cancelAmount = cancelAmount;
        this.canceledAt = LocalDateTime.now();
    }
}
