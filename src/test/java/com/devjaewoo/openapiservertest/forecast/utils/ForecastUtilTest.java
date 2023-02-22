package com.devjaewoo.openapiservertest.forecast.utils;

import com.devjaewoo.openapiservertest.forecast.dto.MidForecastSearch;
import com.devjaewoo.openapiservertest.forecast.dto.UltraForecastSearch;
import com.devjaewoo.openapiservertest.forecast.dto.VillageForecastSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.*;

class ForecastUtilTest {

    @Test
    @DisplayName("중기예보 URI 생성 테스트")
    void getMidForecastUri() {
        // given
        int pageNo = 1;
        int numOfRows = 2;
        String regId = "abc";
        String tmFc = "def";
        String apiKey = "apiKey";

        MidForecastSearch midForecastSearch = new MidForecastSearch(pageNo, numOfRows, regId, tmFc);

        // when
        URI uri = ForecastUtil.getMidForecastUri(midForecastSearch, apiKey);

        // then
        assertThat(uri).hasParameter("dataType", "JSON");
        assertThat(uri).hasParameter("pageNo", String.valueOf(pageNo));
        assertThat(uri).hasParameter("numOfRows", String.valueOf(numOfRows));
        assertThat(uri).hasParameter("regId", regId);
        assertThat(uri).hasParameter("tmFc", tmFc);
        assertThat(uri).hasParameter("ServiceKey", apiKey);
    }

    @Test
    @DisplayName("단기예보 URI 생성 테스트")
    void getVillageForecastUri() {
        // given
        int pageNo = 1;
        int numOfRows = 2;
        String baseDate = "abc";
        String baseTime = "def";
        int nx = 3;
        int ny = 4;
        String apiKey = "apiKey";

        VillageForecastSearch villageForecastSearch = new VillageForecastSearch(pageNo, numOfRows, baseDate, baseTime, nx, ny);

        // when
        URI uri = ForecastUtil.getVillageForecastUri(villageForecastSearch, apiKey);

        // then
        assertThat(uri).hasParameter("dataType", "JSON");
        assertThat(uri).hasParameter("pageNo", String.valueOf(pageNo));
        assertThat(uri).hasParameter("numOfRows", String.valueOf(numOfRows));
        assertThat(uri).hasParameter("base_date", baseDate);
        assertThat(uri).hasParameter("base_time", baseTime);
        assertThat(uri).hasParameter("nx", String.valueOf(nx));
        assertThat(uri).hasParameter("ny", String.valueOf(ny));
        assertThat(uri).hasParameter("ServiceKey", apiKey);
    }

    @Test
    @DisplayName("초단기예보 URI 생성 테스트")
    void getUltraForecastUri() {
        // given
        int pageNo = 1;
        int numOfRows = 2;
        String baseDate = "abc";
        String baseTime = "def";
        int nx = 3;
        int ny = 4;
        String apiKey = "apiKey";

        UltraForecastSearch ultraForecastSearch = new UltraForecastSearch(pageNo, numOfRows, baseDate, baseTime, nx, ny);

        // when
        URI uri = ForecastUtil.getUltraForecastUri(ultraForecastSearch, apiKey);

        // then
        assertThat(uri).hasParameter("dataType", "JSON");
        assertThat(uri).hasParameter("pageNo", String.valueOf(pageNo));
        assertThat(uri).hasParameter("numOfRows", String.valueOf(numOfRows));
        assertThat(uri).hasParameter("base_date", baseDate);
        assertThat(uri).hasParameter("base_time", baseTime);
        assertThat(uri).hasParameter("nx", String.valueOf(nx));
        assertThat(uri).hasParameter("ny", String.valueOf(ny));
        assertThat(uri).hasParameter("ServiceKey", apiKey);
    }
}