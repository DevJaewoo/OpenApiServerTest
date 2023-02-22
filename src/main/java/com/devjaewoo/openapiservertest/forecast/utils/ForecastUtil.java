package com.devjaewoo.openapiservertest.forecast.utils;

import com.devjaewoo.openapiservertest.forecast.dto.MidForecastSearch;
import com.devjaewoo.openapiservertest.forecast.dto.UltraForecastSearch;
import com.devjaewoo.openapiservertest.forecast.dto.VillageForecastSearch;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ForecastUtil {

    private static final String domain = "http://apis.data.go.kr/1360000";

    public static URI getMidForecastUri(MidForecastSearch search, String apiKey) {
        String uri = UriComponentsBuilder.fromHttpUrl(domain + "/MidFcstInfoService/getMidLandFcst")
                .queryParam("dataType", "JSON")
                .queryParam("pageNo", search.pageNo())
                .queryParam("numOfRows", search.numOfRows())
                .queryParam("regId", search.regId())
                .queryParam("tmFc", search.tmFc())
                .toUriString();

        uri += "&ServiceKey=" + apiKey;
        return URI.create(uri);
    }

    public static URI getVillageForecastUri(VillageForecastSearch search, String apiKey) {
        String uri = UriComponentsBuilder.fromHttpUrl(domain + "/VilageFcstInfoService_2.0/getVilageFcst")
                .queryParam("dataType", "JSON")
                .queryParam("pageNo", search.pageNo())
                .queryParam("numOfRows", search.numOfRows())
                .queryParam("base_date", search.baseDate())
                .queryParam("base_time", search.baseTime())
                .queryParam("nx", search.nx())
                .queryParam("ny", search.ny())
                .toUriString();

        uri += "&ServiceKey=" + apiKey;
        return URI.create(uri);
    }

    public static URI getUltraForecastUri(UltraForecastSearch search, String apiKey) {
        String uri = UriComponentsBuilder.fromHttpUrl(domain + "/VilageFcstInfoService_2.0/getUltraSrtFcst")
                .queryParam("dataType", "JSON")
                .queryParam("pageNo", search.pageNo())
                .queryParam("numOfRows", search.numOfRows())
                .queryParam("base_date", search.baseDate())
                .queryParam("base_time", search.baseTime())
                .queryParam("nx", search.nx())
                .queryParam("ny", search.ny())
                .toUriString();

        uri += "&ServiceKey=" + apiKey;
        return URI.create(uri);
    }
}
