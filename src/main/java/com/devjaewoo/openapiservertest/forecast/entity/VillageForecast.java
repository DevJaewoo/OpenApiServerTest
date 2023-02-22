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
public class VillageForecast extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String baseDate;
    String baseTime;
    String category;
    String fcstDate;
    String fcstTime;
    String fcstValue;
    int nx;
    int ny;

    public static VillageForecast create(String baseDate, String baseTime, String category, String fcstDate, String fcstTime, String fcstValue, int nx, int ny) {
        VillageForecast villageForecast = new VillageForecast();

        villageForecast.baseDate = baseDate;
        villageForecast.baseTime = baseTime;
        villageForecast.category = category;
        villageForecast.fcstDate = fcstDate;
        villageForecast.fcstTime = fcstTime;
        villageForecast.fcstValue = fcstValue;
        villageForecast.nx = nx;
        villageForecast.ny = ny;

        return villageForecast;
    }
}
