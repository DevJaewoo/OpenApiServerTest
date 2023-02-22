package com.devjaewoo.openapiservertest.forecast.entity;

import com.devjaewoo.openapiservertest.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UltraForecast extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private int nx;
    private int ny;

    public static UltraForecast create(String baseDate, String baseTime, String category, String fcstDate, String fcstTime, String fcstValue, int nx, int ny) {
        UltraForecast ultraForecast = new UltraForecast();

        ultraForecast.baseDate = baseDate;
        ultraForecast.baseTime = baseTime;
        ultraForecast.category = category;
        ultraForecast.fcstDate = fcstDate;
        ultraForecast.fcstTime = fcstTime;
        ultraForecast.fcstValue = fcstValue;
        ultraForecast.nx = nx;
        ultraForecast.ny = ny;

        return ultraForecast;
    }
}
