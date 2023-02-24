package com.devjaewoo.openapiservertest.forecast.utils;

import com.devjaewoo.openapiservertest.forecast.dto.ForecastErrorCode;
import com.devjaewoo.openapiservertest.forecast.dto.ForecastItem;
import com.devjaewoo.openapiservertest.forecast.dto.OpenApiResponse;
import com.devjaewoo.openapiservertest.global.exception.OpenApiException;
import com.devjaewoo.openapiservertest.global.exception.RestApiException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OpenApiResponseValidatorTest {

    @Test
    @DisplayName("성공")
    void success() {
        // given
        ForecastItem item1 = new ForecastItem() {};
        ForecastItem item2 = new ForecastItem() {};

        OpenApiResponse.Response.Header header = new OpenApiResponse.Response.Header("00", "성공");
        OpenApiResponse.Response.Body<ForecastItem> body = new OpenApiResponse.Response.Body<>(
                "JSON", 1, 1, 1,
                new OpenApiResponse.Response.Body.Items<>(List.of(item1, item2))
        );

        OpenApiResponse.Response<ForecastItem> response = new OpenApiResponse.Response<>(header, body);
        OpenApiResponse<ForecastItem> apiResponse = new OpenApiResponse<>(response);

        // when
        OpenApiResponse.Response.Body<ForecastItem> validatedBody = OpenApiResponseValidator.validateResponse(apiResponse);

        // then
        assertThat(validatedBody).isEqualTo(body);
    }

    @Test
    @DisplayName("Open API 오류")
    public void openApiException() {
        // given
        String resultCode = "01";
        String resultMsg = "APPLICATION_ERROR";

        OpenApiResponse.Response.Header header = new OpenApiResponse.Response.Header(resultCode, resultMsg);

        OpenApiResponse.Response<ForecastItem> response = new OpenApiResponse.Response<>(header, null);
        OpenApiResponse<ForecastItem> apiResponse = new OpenApiResponse<>(response);

        //when
        //then
        assertThrows(OpenApiException.class, () -> OpenApiResponseValidator.validateResponse(apiResponse), resultMsg);
    }

    @Test
    @DisplayName("응답 값 없음")
    public void noContent() {
        // given
        String resultCode = "00";
        String resultMsg = "성공";

        OpenApiResponse.Response.Header header = new OpenApiResponse.Response.Header(resultCode, resultMsg);

        OpenApiResponse.Response<ForecastItem> response = new OpenApiResponse.Response<>(header, null);
        OpenApiResponse<ForecastItem> apiResponse = new OpenApiResponse<>(response);

        //when
        //then
        assertThrows(RestApiException.class, () -> OpenApiResponseValidator.validateResponse(apiResponse), ForecastErrorCode.INVALID_BODY.message);
    }
}