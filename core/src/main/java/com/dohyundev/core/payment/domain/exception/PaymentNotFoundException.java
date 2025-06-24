package com.dohyundev.core.payment.domain.exception;

import com.dohyundev.common.CommonError;
import com.dohyundev.common.exception.NotFoundException;

public class PaymentNotFoundException extends NotFoundException {

    private static final CommonError error = new CommonError(
            "PAYMENT_NOT_FOUND",
            "결제 정보를 찾을 수 없습니다."
    );

    public PaymentNotFoundException() {
        super(error);
    }
}
