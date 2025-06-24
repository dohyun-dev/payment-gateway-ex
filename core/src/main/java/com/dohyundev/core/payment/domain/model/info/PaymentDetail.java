package com.dohyundev.core.payment.domain.model.info;

import com.dohyundev.core.payment.domain.enums.PaymentCancelStatus;
import com.dohyundev.core.payment.domain.model.Payment;
import com.dohyundev.core.payment.domain.model.PaymentId;
import com.dohyundev.core.payment.domain.model.info.cancel.PaymentCancel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_detail_type")
@Getter
public abstract class PaymentDetail {
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "payment_id"))
    private PaymentId id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId("payment_id")
    @JoinColumn(name = "payment_id")
    private Payment payment;

    protected long amount;

    private LocalDateTime approvedAt;

    @ElementCollection
    @CollectionTable(name = "payment_cancel", joinColumns = {
            @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    })
    private List<PaymentCancel> cancelHistories = new ArrayList<>();

    protected PaymentDetail(long amount) {
        this.amount = amount;
        this.approvedAt = LocalDateTime.now();
    }

    public void cancel(PaymentCancel cancel) {
        cancelHistories.add(cancel);
    }

    public long calculateRefundableAmount() {
        return amount - cancelHistories.stream().filter(cancel -> PaymentCancelStatus.DONE.equals(cancel.getStatus())).map(PaymentCancel::getCancelAmount).reduce(0L, Long::sum);
    }
}
