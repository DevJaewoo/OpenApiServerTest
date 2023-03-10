package com.devjaewoo.openapiservertest.global.exception;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestApiException.class)
    public ResponseEntity<Object> handleRestApiException(RestApiException e) {
        return buildErrorResponse(e.getErrorCode());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("handleIllegalArgumentException: ", e);
        return buildErrorResponse(CommonErrorCode.INVALID_PARAMETER);
    }

    @ExceptionHandler(OpenApiException.class)
    public ResponseEntity<Object> handleOpenApiException(OpenApiException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getCode(), e.getMessage(), null));
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {

        return buildErrorResponse(ex);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleBindException(
            @NonNull BindException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {

        return buildErrorResponse(ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception e) {
        log.warn("handleAllException: ", e);
        return buildErrorResponse(CommonErrorCode.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> buildErrorResponse(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus()).body(new ErrorResponse(errorCode));
    }

    private ResponseEntity<Object> buildErrorResponse(BindException e) {

        List<ErrorResponse.ValidationError> errorList = e.getBindingResult().getFieldErrors().stream()
                .map(ErrorResponse.ValidationError::new)
                .toList();

        ErrorCode errorCode = CommonErrorCode.INVALID_PARAMETER;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(new ErrorResponse(errorCode.name(), errorCode.getMessage(), errorList));
    }
}
