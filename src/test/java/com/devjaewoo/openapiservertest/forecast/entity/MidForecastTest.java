package com.devjaewoo.openapiservertest.forecast.entity;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MidForecastTest {

    @Test
    @DisplayName("정적 팩토리 메서드 매개변수 순서 테스트")
    public void create() {
        //given
        String regId = "regId";
        int rnSt3Am = 30;
        int rnSt3Pm = 35;
        int rnSt4Am = 40;
        int rnSt4Pm = 45;
        int rnSt5Am = 50;
        int rnSt5Pm = 55;
        int rnSt6Am = 60;
        int rnSt6Pm = 65;
        int rnSt7Am = 70;
        int rnSt7Pm = 75;
        int rnSt8 = 80;
        int rnSt9 = 90;
        int rnSt10 = 100;

        String wf3Am = "wf3Am";
        String wf3Pm = "wf3Pm";
        String wf4Am = "wf4Am";
        String wf4Pm = "wf4Pm";
        String wf5Am = "wf5Am";
        String wf5Pm = "wf5Pm";
        String wf6Am = "wf6Am";
        String wf6Pm = "wf6Pm";
        String wf7Am = "wf7Am";
        String wf7Pm = "wf7Pm";
        String wf8 = "wf8";
        String wf9 = "wf9";
        String wf10 = "wf10";

        //when
        MidForecast midForecast = MidForecast.create(
                regId, rnSt3Am, rnSt3Pm, rnSt4Am, rnSt4Pm, rnSt5Am, rnSt5Pm, rnSt6Am, rnSt6Pm, rnSt7Am, rnSt7Pm, rnSt8, rnSt9, rnSt10,
                wf3Am, wf3Pm, wf4Am, wf4Pm, wf5Am, wf5Pm, wf6Am, wf6Pm, wf7Am, wf7Pm, wf8, wf9, wf10);

        //then
        assertThat(midForecast.getRegId()).isEqualTo(regId);
        assertThat(midForecast.getRnSt3Am()).isEqualTo(rnSt3Am);
        assertThat(midForecast.getRnSt3Pm()).isEqualTo(rnSt3Pm);
        assertThat(midForecast.getRnSt4Am()).isEqualTo(rnSt4Am);
        assertThat(midForecast.getRnSt4Pm()).isEqualTo(rnSt4Pm);
        assertThat(midForecast.getRnSt5Am()).isEqualTo(rnSt5Am);
        assertThat(midForecast.getRnSt5Pm()).isEqualTo(rnSt5Pm);
        assertThat(midForecast.getRnSt6Am()).isEqualTo(rnSt6Am);
        assertThat(midForecast.getRnSt6Pm()).isEqualTo(rnSt6Pm);
        assertThat(midForecast.getRnSt7Am()).isEqualTo(rnSt7Am);
        assertThat(midForecast.getRnSt7Pm()).isEqualTo(rnSt7Pm);
        assertThat(midForecast.getRnSt8()).isEqualTo(rnSt8);
        assertThat(midForecast.getRnSt9()).isEqualTo(rnSt9);
        assertThat(midForecast.getRnSt10()).isEqualTo(rnSt10);
    }
}