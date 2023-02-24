package com.devjaewoo.openapiservertest.forecast.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

// QueryDSL 조회용 DTO
public record UltraForecastSearch2(

        @Min(1)
        int pageNo,

        @Min(1)
        int numOfRows,

        @Pattern(regexp = "\\d{8}", message = "Date must be in yyyyMMdd format")
        String baseDate,

        @Pattern(regexp = "\\d{4}", message = "Date must be in HHmm format")
        String baseTime,
        String category,

        @Pattern(regexp = "\\d{8}", message = "Date must be in yyyyMMdd format")
        String fcstDate,

        @Pattern(regexp = "\\d{4}", message = "Date must be in HHmm format")
        String fcstTime,

        String fcstValue,

        @Min(1)
        Integer nx,

        @Min(1)
        Integer ny
) {
}
