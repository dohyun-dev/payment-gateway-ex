package com.dohyundev.api.advice;

import com.dohyundev.common.CommonError;
import com.dohyundev.common.exception.BusinessException;
import lombok.Data;

@Data
public class ErrorResponse {
    private CommonError error;

    public ErrorResponse(BusinessException exception) {
        this.error = exception.getError();
    }
}
