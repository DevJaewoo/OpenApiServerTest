package com.devjaewoo.openapiservertest.forecast.repository;

import com.devjaewoo.openapiservertest.forecast.dto.UltraForecastSearch2;
import com.devjaewoo.openapiservertest.forecast.entity.UltraForecast;
import org.springframework.data.domain.Page;

public interface UltraForecastRepositoryCustom {
    Page<UltraForecast> search(UltraForecastSearch2 search);
}
