package com.devjaewoo.openapiservertest.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OpenApiException extends RuntimeException {
    private final String code;
    private final String message;
}
