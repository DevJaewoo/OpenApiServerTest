package com.devjaewoo.openapiservertest.forecast.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public record MidForecastSearch(

        @Min(1)
        int pageNo,

        @Min(1)
        int numOfRows,

        @Length(min = 8, max = 8)
        String regId,

        @Pattern(regexp = "\\d{12}", message = "Date must be in yyyyMMddHHmm format")
        String tmFc
) {
}
