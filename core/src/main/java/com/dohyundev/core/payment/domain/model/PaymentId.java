package com.dohyundev.core.payment.domain.model;

import com.github.f4b6a3.tsid.TsidCreator;

public record PaymentId(
        String value
) {
    public static PaymentId create() {
        return new PaymentId(TsidCreator.getTsid().toString());
    }
}
