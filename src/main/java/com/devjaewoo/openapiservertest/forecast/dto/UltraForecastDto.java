package com.devjaewoo.openapiservertest.forecast.dto;

import com.devjaewoo.openapiservertest.forecast.entity.UltraForecastData;
import com.fasterxml.jackson.annotation.JsonProperty;

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

        public UltraForecastData toEntity() {
                return UltraForecastData.builder()
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
}