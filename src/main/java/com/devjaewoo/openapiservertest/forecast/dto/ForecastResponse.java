package com.devjaewoo.openapiservertest.forecast.dto;

import java.util.List;

public record ForecastResponse<T extends ForecastItem>(
        int page,
        int numOfRows,
        int totalCount,
        List<T> data
) {

    public static <T extends ForecastItem> ForecastResponse<T> from(OpenApiResponse.Response.Body<T> body) {
        return new ForecastResponse<>(
                body.pageNo(),
                body.numOfRows(),
                body.totalCount(),
                body.items().item()
        );
    }
}
