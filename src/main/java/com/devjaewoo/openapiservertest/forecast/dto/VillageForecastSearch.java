package com.devjaewoo.openapiservertest.forecast.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public record VillageForecastSearch(

        @Min(1)
        int pageNo,

        @Min(1)
        int numOfRows,

        @Pattern(regexp = "\\d{8}", message = "Date must be in yyyyMMdd format")
        String baseDate,

        @Pattern(regexp = "\\d{4}", message = "Date must be in HHmm format")
        String baseTime,

        @Min(1)
        int nx,

        @Min(1)
        int ny
) {
}
