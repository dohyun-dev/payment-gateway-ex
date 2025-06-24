package com.dohyundev.common.exception;

import com.dohyundev.common.CommonError;
import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final CommonError error;

    public BusinessException(CommonError error) {
        this.error = error;
    }
}
