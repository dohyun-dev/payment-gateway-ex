package com.dohyundev.core.payment.domain.model;

import com.dohyundev.core.payment.domain.enums.PaymentStatus;
import com.dohyundev.core.payment.domain.model.info.PaymentDetail;
import com.dohyundev.core.payment.domain.model.info.cancel.PaymentCancel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Payment {
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "payment_id"))
    private PaymentId paymentId;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.READY;

    private Payment(PaymentId paymentId) {
        this.paymentId = paymentId;
    }

    public static Payment create() {
        return new Payment(PaymentId.create());
    }

    public void approve(PaymentDetail detail) {
        detail.setPayment(this);
        this.paymentDetail = detail;
        this.status = PaymentStatus.DONE;
    }

    public void cancel(PaymentCancel paymentCancel) {
        paymentDetail.cancel(paymentCancel);
    }
}
