package com.dohyundev.api.advice;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }
}
