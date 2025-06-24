package com.dohyundev.common.exception;

import com.dohyundev.common.CommonError;

public abstract class NotFoundException extends BusinessException {
    public NotFoundException(CommonError error) {
        super(error);
    }
}
