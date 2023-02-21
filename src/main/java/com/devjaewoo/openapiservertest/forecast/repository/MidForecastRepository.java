package com.devjaewoo.openapiservertest.forecast.repository;

import com.devjaewoo.openapiservertest.forecast.entity.MidForecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MidForecastRepository extends JpaRepository<MidForecast, Long> {
}
