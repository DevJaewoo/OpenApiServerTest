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
public class MidForecast extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regId;
    private int rnSt3Am;
    private int rnSt3Pm;
    private int rnSt4Am;
    private int rnSt4Pm;
    private int rnSt5Am;
    private int rnSt5Pm;
    private int rnSt6Am;
    private int rnSt6Pm;
    private int rnSt7Am;
    private int rnSt7Pm;
    private int rnSt8;
    private int rnSt9;
    private int rnSt10;
    
    private String wf3Am;
    private String wf3Pm;
    private String wf4Am;
    private String wf4Pm;
    private String wf5Am;
    private String wf5Pm;
    private String wf6Am;
    private String wf6Pm;
    private String wf7Am;
    private String wf7Pm;
    private String wf8;
    private String wf9;
    private String wf10;

    public static MidForecast create(
            String regId,
            int rnSt3Am, int rnSt3Pm, int rnSt4Am, int rnSt4Pm, int rnSt5Am, int rnSt5Pm, int rnSt6Am, int rnSt6Pm, int rnSt7Am, int rnSt7Pm, int rnSt8, int rnSt9, int rnSt10,
            String wf3Am, String wf3Pm, String wf4Am, String wf4Pm, String wf5Am, String wf5Pm, String wf6Am, String wf6Pm, String wf7Am, String wf7Pm, String wf8, String wf9, String wf10
    ) {
        MidForecast midForecast = new MidForecast();

        midForecast.regId = regId;
        midForecast.rnSt3Am = rnSt3Am;
        midForecast.rnSt3Pm = rnSt3Pm;
        midForecast.rnSt4Am = rnSt4Am;
        midForecast.rnSt4Pm = rnSt4Pm;
        midForecast.rnSt5Am = rnSt5Am;
        midForecast.rnSt5Pm = rnSt5Pm;
        midForecast.rnSt6Am = rnSt6Am;
        midForecast.rnSt6Pm = rnSt6Pm;
        midForecast.rnSt7Am = rnSt7Am;
        midForecast.rnSt7Pm = rnSt7Pm;
        midForecast.rnSt8 = rnSt8;
        midForecast.rnSt9 = rnSt9;
        midForecast.rnSt10 = rnSt10;
        midForecast.wf3Am = wf3Am;
        midForecast.wf3Pm = wf3Pm;
        midForecast.wf4Am = wf4Am;
        midForecast.wf4Pm = wf4Pm;
        midForecast.wf5Am = wf5Am;
        midForecast.wf5Pm = wf5Pm;
        midForecast.wf6Am = wf6Am;
        midForecast.wf6Pm = wf6Pm;
        midForecast.wf7Am = wf7Am;
        midForecast.wf7Pm = wf7Pm;
        midForecast.wf8 = wf8;
        midForecast.wf9 = wf9;
        midForecast.wf10 = wf10;

        return midForecast;
    }
}
