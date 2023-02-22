package com.devjaewoo.openapiservertest.forecast.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

// QueryDSL 조회용 DTO
public record UltraForecastSearch2(

        @Min(1)
        int page,

        @Min(1)
        int size,

        @Pattern(regexp = "\\d{8}", message = "Date must be in yyyyMMdd format")
        String baseDate,

        @Pattern(regexp = "\\d{4}", message = "Date must be in HHmm format")
        String baseTime,

        @Pattern(regexp = "\\d{8}", message = "Date must be in yyyyMMdd format")
        String fcstDate,

        @Pattern(regexp = "\\d{4}", message = "Date must be in HHmm format")
        String fcstTime,

        String fcstValue,
        String category,

        @Min(1)
        Integer nx,

        @Min(1)
        Integer ny
) {
}
