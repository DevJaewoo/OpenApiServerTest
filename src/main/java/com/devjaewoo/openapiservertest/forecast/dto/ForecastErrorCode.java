package com.devjaewoo.openapiservertest.forecast.dto;

import com.devjaewoo.openapiservertest.global.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ForecastErrorCode implements ErrorCode {
    INVALID_BODY(HttpStatus.BAD_REQUEST, "Body가 수신되지 않았습니다."),
    DATA_PARSE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "데이터 변환 중 오류가 발생했습니다."),
    ;
    public final HttpStatus httpStatus;
    public final String message;
}
