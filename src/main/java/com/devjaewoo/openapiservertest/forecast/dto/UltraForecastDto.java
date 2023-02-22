package com.devjaewoo.openapiservertest.forecast.dto;

import com.devjaewoo.openapiservertest.forecast.entity.UltraForecast;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UltraForecastDto(

        @JsonProperty("baseDate")
        String baseDate,

        @JsonProperty("baseTime")
        String baseTime,

        @JsonProperty("category")
        String category,

        @JsonProperty("fcstDate")
        String fcstDate,

        @JsonProperty("fcstTime")
        String fcstTime,

        @JsonProperty("fcstValue")
        String fcstValue,

        @JsonProperty("nx")
        int nx,

        @JsonProperty("ny")
        int ny

) implements ForecastItem {

    public UltraForecast toEntity() {
        return UltraForecast.builder()
                .baseDate(baseDate)
                .baseTime(baseTime)
                .category(category)
                .fcstDate(fcstDate)
                .fcstTime(fcstTime)
                .fcstValue(fcstValue)
                .nx(nx)
                .ny(ny)
                .build();
    }

    public static UltraForecastDto from(UltraForecast ultraForecast) {
        return UltraForecastDto.builder()
                .baseDate(ultraForecast.getBaseDate())
                .baseTime(ultraForecast.getBaseTime())
                .category(ultraForecast.getCategory())
                .fcstDate(ultraForecast.getFcstDate())
                .fcstTime(ultraForecast.getFcstTime())
                .fcstValue(ultraForecast.getFcstValue())
                .nx(ultraForecast.getNx())
                .ny(ultraForecast.getNy())
                .build();
    }
}