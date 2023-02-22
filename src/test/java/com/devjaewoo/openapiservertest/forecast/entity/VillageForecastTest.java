package com.devjaewoo.openapiservertest.forecast.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VillageForecastTest {

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
        VillageForecast villageForecast = VillageForecast.create(baseDate, baseTime, category, fcstDate, fcstTime, fcstValue, nx, ny);

        //then
        assertThat(villageForecast.getBaseDate()).isEqualTo(baseDate);
        assertThat(villageForecast.getBaseTime()).isEqualTo(baseTime);
        assertThat(villageForecast.getCategory()).isEqualTo(category);
        assertThat(villageForecast.getFcstDate()).isEqualTo(fcstDate);
        assertThat(villageForecast.getFcstTime()).isEqualTo(fcstTime);
        assertThat(villageForecast.getFcstValue()).isEqualTo(fcstValue);
        assertThat(villageForecast.getNx()).isEqualTo(nx);
        assertThat(villageForecast.getNy()).isEqualTo(ny);
    }
}