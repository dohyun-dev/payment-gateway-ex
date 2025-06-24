package com.dohyundev.core.van;

import com.dohyundev.core.payment.domain.model.info.PaymentDetail;

public interface VanClient {
    boolean requestApprove(PaymentDetail paymentDetail);
}