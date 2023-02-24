package com.devjaewoo.openapiservertest.forecast.controller;

import com.devjaewoo.openapiservertest.forecast.dto.ForecastResponse;
import com.devjaewoo.openapiservertest.forecast.dto.MidForecastDto;
import com.devjaewoo.openapiservertest.forecast.dto.MidForecastSearch;
import com.devjaewoo.openapiservertest.forecast.service.ForecastService;
import com.devjaewoo.openapiservertest.forecast.service.OpenApiService;
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

        @Test
        void success() throws Exception {
            // given
            MidForecastSearch search = new MidForecastSearch(1, 1, "12345678", "202302241230");
            String uri = UriComponentsBuilder.fromUriString("/api/forecast/mid")
                    .queryParam("pageNo", search.pageNo())
                    .queryParam("numOfRows", search.numOfRows())
                    .queryParam("regId", search.regId())
                    .queryParam("tmFc", search.tmFc())
                    .toUriString();

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
                    .andExpect(jsonPath("$.page", search.pageNo()).exists())
                    .andExpect(jsonPath("$.numOfRows", search.numOfRows()).exists())
                    .andExpect(jsonPath("$.data.length()").value(2))
                    .andReturn();
        }
    }
}