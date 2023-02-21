package com.devjaewoo.openapiservertest.forecast.repository;

import com.devjaewoo.openapiservertest.forecast.entity.VillageForecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillageForecastRepository extends JpaRepository<VillageForecast, Long> {
}
