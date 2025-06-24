package com.dohyundev.core.payment.domain.model.info.cancel;

import com.dohyundev.core.payment.domain.enums.PaymentCancelStatus;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Getter
public class CardPaymentCancel extends PaymentCancel {
    private final  String transactionId;

    public CardPaymentCancel(String transactionId, long cancelAmount, PaymentCancelStatus status) {
        super(status, cancelAmount);
        this.transactionId = transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPaymentCancel that)) return false;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transactionId);
    }
}
