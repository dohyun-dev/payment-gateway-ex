package com.dohyundev.common.exception;

import com.dohyundev.common.CommonError;

public abstract class ForbiddenException extends BusinessException {
    private static final CommonError FORBIDDEN_ERROR = new CommonError(
            "FORBIDDEN_ERROR",
            "접근 권한이 없습니다."
    );

    public ForbiddenException() {
        super(FORBIDDEN_ERROR);
    }
}
