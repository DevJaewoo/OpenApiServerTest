package com.devjaewoo.openapiservertest.forecast.controller;

import com.devjaewoo.openapiservertest.forecast.dto.*;
import com.devjaewoo.openapiservertest.forecast.service.ForecastService;
import com.devjaewoo.openapiservertest.forecast.service.OpenApiService;
import com.devjaewoo.openapiservertest.global.exception.OpenApiException;
import com.devjaewoo.openapiservertest.global.exception.RestApiException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ForecastController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
class ForecastControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpenApiService openApiService;

    @MockBean
    private ForecastService forecastService;

    @Nested
    @DisplayName("중기 예보 API")
    class GetMidForecastData {
        private String getUri(MidForecastSearch search) {
            return UriComponentsBuilder.fromUriString("/api/forecast/mid")
                    .queryParam("pageNo", search.pageNo())
                    .queryParam("numOfRows", search.numOfRows())
                    .queryParam("regId", search.regId())
                    .queryParam("tmFc", search.tmFc())
                    .toUriString();
        }

        @Test
        @DisplayName("성공")
        void success() throws Exception {
            // given
            MidForecastSearch search = new MidForecastSearch(1, 1, "12345678", "202302241230");
            String uri = getUri(search);

            MidForecastDto midForecastDto1 = new MidForecastDto(
                    "regId", 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 90, 100,
                    "wf3Am", "wf3Pm", "wf4Am", "wf4Pm", "wf5Am", "wf5Pm", "wf6Am", "wf6Pm", "wf7Am", "wf7Pm", "wf8", "wf9", "wf10");

            MidForecastDto midForecastDto2 = new MidForecastDto(
                    "regId2", 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 90, 100,
                    "wf3Am2", "wf3Pm2", "wf4Am2", "wf4Pm2", "wf5Am2", "wf5Pm2", "wf6Am2", "wf6Pm2", "wf7Am2", "wf7Pm2", "wf82", "wf92", "wf102");


            ForecastResponse<MidForecastDto> response = new ForecastResponse<>(1, 1, 2, List.of(midForecastDto1, midForecastDto2));

            given(openApiService.requestMidForecastData(any()))
                    .willReturn(response);

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(document("/api/forecast/mid"))
                    .andExpect(jsonPath("$.page").value(search.pageNo()))
                    .andExpect(jsonPath("$.numOfRows").value(search.numOfRows()))
                    .andExpect(jsonPath("$.data.length()").value(2))
                    .andReturn();
        }

        @Test
        @DisplayName("Open API 응답 오류")
        void openApiException() throws Exception {
            // given
            MidForecastSearch search = new MidForecastSearch(1, 1, "12345678", "202302241230");
            String uri = getUri(search);

            String code = "01";
            String message = "APPLICATION_ERROR";

            given(openApiService.requestMidForecastData(any()))
                    .willThrow(new OpenApiException(code, message));

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andDo(document("/api/forecast/mid"))
                    .andExpect(jsonPath("$.code").value(code))
                    .andExpect(jsonPath("$.message").value(message))
                    .andReturn();
        }

        @Test
        @DisplayName("비어있는 데이터 반환")
        void noContent() throws Exception {
            // given
            MidForecastSearch search = new MidForecastSearch(1, 1, "12345678", "202302241230");
            String uri = getUri(search);

            given(openApiService.requestMidForecastData(any()))
                    .willThrow(new RestApiException(ForecastErrorCode.INVALID_BODY));

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andDo(document("/api/forecast/mid"))
                    .andExpect(jsonPath("$.code").value(ForecastErrorCode.INVALID_BODY.name()))
                    .andExpect(jsonPath("$.message").value(ForecastErrorCode.INVALID_BODY.message))
                    .andReturn();
        }
    }

    @Nested
    @DisplayName("단기 예보 API")
    class GetVillageForecastData {

        private String getUri(VillageForecastSearch search) {
            return UriComponentsBuilder.fromUriString("/api/forecast/village")
                    .queryParam("pageNo", search.pageNo())
                    .queryParam("numOfRows", search.numOfRows())
                    .queryParam("baseDate", search.baseDate())
                    .queryParam("baseTime", search.baseTime())
                    .queryParam("nx", search.nx())
                    .queryParam("ny", search.ny())
                    .toUriString();
        }

        @Test
        @DisplayName("성공")
        void success() throws Exception {
            // given
            VillageForecastSearch search = new VillageForecastSearch(1, 1, "20230224", "1230", 1, 2);
            String uri = getUri(search);

            VillageForecastDto villageForecastDto1 = new VillageForecastDto("20230224", "1230", "AAA", "20230224", "1300", "1", 1, 2);
            VillageForecastDto villageForecastDto2 = new VillageForecastDto("20230224", "1230", "AAA", "20230224", "1300", "1", 1, 2);

            ForecastResponse<VillageForecastDto> response = new ForecastResponse<>(1, 1, 2, List.of(villageForecastDto1, villageForecastDto2));

            given(openApiService.requestVillageForecastData(any()))
                    .willReturn(response);

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(document("/api/forecast/village"))
                    .andExpect(jsonPath("$.page").value(search.pageNo()))
                    .andExpect(jsonPath("$.numOfRows").value(search.numOfRows()))
                    .andExpect(jsonPath("$.data.length()").value(2))
                    .andReturn();
        }

        @Test
        @DisplayName("Open API 응답 오류")
        void openApiException() throws Exception {
            // given
            VillageForecastSearch search = new VillageForecastSearch(1, 1, "20230224", "1230", 1, 2);
            String uri = getUri(search);

            String code = "01";
            String message = "APPLICATION_ERROR";

            given(openApiService.requestVillageForecastData(any()))
                    .willThrow(new OpenApiException(code, message));

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andDo(document("/api/forecast/village"))
                    .andExpect(jsonPath("$.code").value(code))
                    .andExpect(jsonPath("$.message").value(message))
                    .andReturn();
        }

        @Test
        @DisplayName("비어있는 데이터 반환")
        void noContent() throws Exception {
            // given
            VillageForecastSearch search = new VillageForecastSearch(1, 1, "20230224", "1230", 1, 2);
            String uri = getUri(search);

            given(openApiService.requestVillageForecastData(any()))
                    .willThrow(new RestApiException(ForecastErrorCode.INVALID_BODY));

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andDo(document("/api/forecast/village"))
                    .andExpect(jsonPath("$.code").value(ForecastErrorCode.INVALID_BODY.name()))
                    .andExpect(jsonPath("$.message").value(ForecastErrorCode.INVALID_BODY.message))
                    .andReturn();
        }
    }
    
    @Nested
    @DisplayName("단기 예보 API")
    class GetUltraForecastData {

        private String getUri(UltraForecastSearch search) {
            return UriComponentsBuilder.fromUriString("/api/forecast/ultra")
                    .queryParam("pageNo", search.pageNo())
                    .queryParam("numOfRows", search.numOfRows())
                    .queryParam("baseDate", search.baseDate())
                    .queryParam("baseTime", search.baseTime())
                    .queryParam("nx", search.nx())
                    .queryParam("ny", search.ny())
                    .toUriString();
        }

        @Test
        @DisplayName("성공")
        void success() throws Exception {
            // given
            UltraForecastSearch search = new UltraForecastSearch(1, 1, "20230224", "1230", 1, 2);
            String uri = getUri(search);

            UltraForecastDto ultraForecastDto1 = new UltraForecastDto("20230224", "1230", "AAA", "20230224", "1300", "1", 1, 2);
            UltraForecastDto ultraForecastDto2 = new UltraForecastDto("20230224", "1230", "AAA", "20230224", "1300", "1", 1, 2);

            ForecastResponse<UltraForecastDto> response = new ForecastResponse<>(1, 1, 2, List.of(ultraForecastDto1, ultraForecastDto2));

            given(openApiService.requestUltraForecastData(any()))
                    .willReturn(response);

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(document("/api/forecast/ultra"))
                    .andExpect(jsonPath("$.page").value(search.pageNo()))
                    .andExpect(jsonPath("$.numOfRows").value(search.numOfRows()))
                    .andExpect(jsonPath("$.data.length()").value(2))
                    .andReturn();
        }

        @Test
        @DisplayName("Open API 응답 오류")
        void openApiException() throws Exception {
            // given
            UltraForecastSearch search = new UltraForecastSearch(1, 1, "20230224", "1230", 1, 2);
            String uri = getUri(search);

            String code = "01";
            String message = "APPLICATION_ERROR";

            given(openApiService.requestUltraForecastData(any()))
                    .willThrow(new OpenApiException(code, message));

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andDo(document("/api/forecast/ultra"))
                    .andExpect(jsonPath("$.code").value(code))
                    .andExpect(jsonPath("$.message").value(message))
                    .andReturn();
        }

        @Test
        @DisplayName("비어있는 데이터 반환")
        void noContent() throws Exception {
            // given
            UltraForecastSearch search = new UltraForecastSearch(1, 1, "20230224", "1230", 1, 2);
            String uri = getUri(search);

            given(openApiService.requestUltraForecastData(any()))
                    .willThrow(new RestApiException(ForecastErrorCode.INVALID_BODY));

            // when
            // then
            mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andDo(document("/api/forecast/ultra"))
                    .andExpect(jsonPath("$.code").value(ForecastErrorCode.INVALID_BODY.name()))
                    .andExpect(jsonPath("$.message").value(ForecastErrorCode.INVALID_BODY.message))
                    .andReturn();
        }
    }
}