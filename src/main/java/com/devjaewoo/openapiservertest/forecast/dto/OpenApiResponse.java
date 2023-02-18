package com.devjaewoo.openapiservertest.forecast.dto;

import org.springframework.lang.Nullable;

import java.util.List;

public record OpenApiResponse<T extends ForecastItem>(Response<T> response) {

    public record Response<T extends ForecastItem> (
            Header header,
            @Nullable
            Body<T> body) {

        public record Header(
                String resultCode,
                String resultMsg
        ) { }

        public record Body<T>(
                String dataType,
                int pageNo,
                int numOfRows,
                int totalCount,
                Items<T> items
        ) {
            public record Items<T>(List<T> item) { }
        }
    }
}
