package com.devjaewoo.openapiservertest.forecast.service;

import com.devjaewoo.openapiservertest.forecast.dto.MidForecastDto;
import com.devjaewoo.openapiservertest.forecast.dto.UltraForecastDto;
import com.devjaewoo.openapiservertest.forecast.dto.UltraForecastSearch2;
import com.devjaewoo.openapiservertest.forecast.dto.VillageForecastDto;
import com.devjaewoo.openapiservertest.forecast.entity.MidForecast;
import com.devjaewoo.openapiservertest.forecast.entity.UltraForecast;
import com.devjaewoo.openapiservertest.forecast.entity.VillageForecast;
import com.devjaewoo.openapiservertest.forecast.repository.MidForecastRepository;
import com.devjaewoo.openapiservertest.forecast.repository.UltraForecastRepository;
import com.devjaewoo.openapiservertest.forecast.repository.VillageForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ForecastService {

    private final MidForecastRepository midForecastRepository;
    private final VillageForecastRepository villageForecastRepository;
    private final UltraForecastRepository ultraForecastRepository;

    @Transactional
    public Long saveMidForecast(MidForecastDto midForecastDto) {
        MidForecast midForecast = midForecastDto.toEntity();
        midForecastRepository.save(midForecast);

        return midForecast.getId();
    }

    @Transactional
    public Long saveVillageForecast(VillageForecastDto villageForecastDto) {
        VillageForecast villageForecast = villageForecastDto.toEntity();
        villageForecastRepository.save(villageForecast);

        return villageForecast.getId();
    }

    @Transactional
    public Long saveUltraForecast(UltraForecastDto ultraForecastDto) {
        UltraForecast ultraForecast = ultraForecastDto.toEntity();
        ultraForecastRepository.save(ultraForecast);

        return ultraForecast.getId();
    }

    public Page<UltraForecastDto> searchUltraForecast(UltraForecastSearch2 search) {
        return ultraForecastRepository.search(search)
                .map(UltraForecastDto::from);
    }
}
