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
public class MidForecastData extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String regId;
    int rnSt3Am;
    int rnSt3Pm;
    int rnSt4Am;
    int rnSt4Pm;
    int rnSt5Am;
    int rnSt5Pm;
    int rnSt6Am;
    int rnSt6Pm;
    int rnSt7Am;
    int rnSt7Pm;
    int rnSt8;
    int rnSt9;
    int rnSt10;
    
    String wf3Am;
    String wf3Pm;
    String wf4Am;
    String wf4Pm;
    String wf5Am;
    String wf5Pm;
    String wf6Am;
    String wf6Pm;
    String wf7Am;
    String wf7Pm;
    String wf8;
    String wf9;
    String wf10;
}
