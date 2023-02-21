package com.devjaewoo.openapiservertest.forecast.repository;

import com.devjaewoo.openapiservertest.forecast.entity.UltraForecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UltraForecastRepository extends JpaRepository<UltraForecast, Long> {
}
