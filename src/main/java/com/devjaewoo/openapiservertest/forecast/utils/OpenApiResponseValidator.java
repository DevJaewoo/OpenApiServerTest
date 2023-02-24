package com.devjaewoo.openapiservertest.forecast.utils;

import com.devjaewoo.openapiservertest.forecast.dto.ForecastErrorCode;
import com.devjaewoo.openapiservertest.forecast.dto.ForecastItem;
import com.devjaewoo.openapiservertest.forecast.dto.OpenApiResponse;
import com.devjaewoo.openapiservertest.global.exception.OpenApiException;
import com.devjaewoo.openapiservertest.global.exception.RestApiException;

public class OpenApiResponseValidator {

    private static void validateHeader(OpenApiResponse.Response.Header header) {
        if(!header.resultCode().equals("00")) {
            throw new OpenApiException(header.resultCode(), header.resultMsg());
        }
    }

    private static void validateBody(OpenApiResponse.Response.Body<?> body) {
        if(body == null) {
            throw new RestApiException(ForecastErrorCode.INVALID_BODY);
        }
    }

    public static <T extends ForecastItem> OpenApiResponse.Response.Body<T> validateResponse(OpenApiResponse<T> response) {
        validateHeader(response.response().header());
        validateBody(response.response().body());
        return response.response().body();
    }
}
