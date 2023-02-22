package com.devjaewoo.openapiservertest.forecast.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UltraForecastTest {
    
    @Test
    @DisplayName("정적 팩토리 메서드 매개변수 순서 테스트")
    public void create() {
        //given
        String baseDate = "20230222";
        String baseTime = "2222";
        String category = "category";
        String fcstDate = "20230223";
        String fcstTime = "1111";
        String fcstValue = "value";
        int nx = 1;
        int ny = 2;

        //when
        UltraForecast ultraForecast = UltraForecast.create(baseDate, baseTime, category, fcstDate, fcstTime, fcstValue, nx, ny);

        //then
        assertThat(ultraForecast.getBaseDate()).isEqualTo(baseDate);
        assertThat(ultraForecast.getBaseTime()).isEqualTo(baseTime);
        assertThat(ultraForecast.getCategory()).isEqualTo(category);
        assertThat(ultraForecast.getFcstDate()).isEqualTo(fcstDate);
        assertThat(ultraForecast.getFcstTime()).isEqualTo(fcstTime);
        assertThat(ultraForecast.getFcstValue()).isEqualTo(fcstValue);
        assertThat(ultraForecast.getNx()).isEqualTo(nx);
        assertThat(ultraForecast.getNy()).isEqualTo(ny);
    }
}