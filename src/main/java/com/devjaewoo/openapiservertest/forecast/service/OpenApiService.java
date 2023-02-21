package com.devjaewoo.openapiservertest.forecast.service;

import com.devjaewoo.openapiservertest.forecast.dto.*;
import com.devjaewoo.openapiservertest.global.exception.OpenApiException;
import com.devjaewoo.openapiservertest.global.exception.RestApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Slf4j
@Service
@RequiredArgsConstructor
public class OpenApiService {

    @Value("${openapi.api-key:key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private URI getMidForecastUri(MidForecastSearch search) {
        String uri = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst")
                .queryParam("dataType", "JSON")
                .queryParam("pageNo", search.pageNo())
                .queryParam("numOfRows", search.numOfRows())
                .queryParam("regId", search.regId())
                .queryParam("tmFc", search.tmFc())
                .toUriString();

        uri += "&ServiceKey=" + apiKey;
        return URI.create(uri);
    }

    private URI getVillageForecastUri(VillageForecastSearch search) {
        String uri = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst")
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

    private URI getUltraForecastUri(UltraForecastSearch search) {
        String uri = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst")
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

    private void validateHeader(OpenApiResponse.Response.Header header) {
        if(!header.resultCode().equals("00")) {
            throw new OpenApiException(header.resultCode(), header.resultMsg());
        }
    }

    private void validateBody(OpenApiResponse.Response.Body<?> body) {
        if(body == null) {
            throw new RestApiException(ForecastErrorCode.INVALID_BODY);
        }
    }

    private <T extends ForecastItem> OpenApiResponse.Response.Body<T> validateResponse(OpenApiResponse<T> response) {
        validateHeader(response.response().header());
        validateBody(response.response().body());
        return response.response().body();
    }

    public ForecastResponse<MidForecastDto> requestMidForecastData(MidForecastSearch search) {
        String response = restTemplate.getForObject(getMidForecastUri(search), String.class);

        OpenApiResponse<MidForecastDto> result;
        try {
            result = objectMapper.readValue(response, new TypeReference<>(){});
        }
        catch (JsonProcessingException e) {
            log.warn(e.getMessage());
            throw new RestApiException(ForecastErrorCode.DATA_PARSE_ERROR);
        }

        return ForecastResponse.from(validateResponse(result));
    }

    public ForecastResponse<VillageForecastDto> requestVillageForecastData(VillageForecastSearch search) {
        String response = restTemplate.getForObject(getVillageForecastUri(search), String.class);

        OpenApiResponse<VillageForecastDto> result;
        try {
            result = objectMapper.readValue(response, new TypeReference<>(){});
        }
        catch (JsonProcessingException e) {
            throw new RestApiException(ForecastErrorCode.DATA_PARSE_ERROR);
        }

        return ForecastResponse.from(validateResponse(result));
    }

    public ForecastResponse<UltraForecastDto> requestUltraForecastData(UltraForecastSearch search) {
        String response = restTemplate.getForObject(getUltraForecastUri(search), String.class);
        log.info(response);

        OpenApiResponse<UltraForecastDto> result;
        try {
            result = objectMapper.readValue(response, new TypeReference<>(){});
        }
        catch (JsonProcessingException e) {
            log.warn(e.getMessage());
            throw new RestApiException(ForecastErrorCode.DATA_PARSE_ERROR);
        }

        return ForecastResponse.from(validateResponse(result));
    }
}
