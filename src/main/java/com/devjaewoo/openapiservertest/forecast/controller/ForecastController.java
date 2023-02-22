package com.devjaewoo.openapiservertest.forecast.controller;

import com.devjaewoo.openapiservertest.forecast.dto.*;
import com.devjaewoo.openapiservertest.forecast.service.ForecastService;
import com.devjaewoo.openapiservertest.forecast.service.OpenApiService;
import com.devjaewoo.openapiservertest.global.dto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/forecast")
@RequiredArgsConstructor
public class ForecastController {

    private final OpenApiService openApiService;
    private final ForecastService forecastService;

    @GetMapping("/mid")
    public ResponseEntity<?> getMidForecastData(@Valid MidForecastSearch search) {
        ForecastResponse<MidForecastDto> response = openApiService.requestMidForecastData(search);
        response.data().forEach(forecastService::saveMidForecast);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/village")
    public ResponseEntity<?> getVillageForecastData(@Valid VillageForecastSearch search) {
        ForecastResponse<VillageForecastDto> response = openApiService.requestVillageForecastData(search);
        response.data().forEach(forecastService::saveVillageForecast);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/ultra")
    public ResponseEntity<?> getUltraForecastData(@Valid UltraForecastSearch search) {
        ForecastResponse<UltraForecastDto> response = openApiService.requestUltraForecastData(search);
        response.data().forEach(forecastService::saveUltraForecast);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/ultra/search")
    public ResponseEntity<?> searchUltraForecastData(@Valid UltraForecastSearch2 search) {
        Page<UltraForecastDto> result = forecastService.searchUltraForecast(search);
        return ResponseEntity.ok(new PageResponseDto<>(result));
    }
}
