package com.devjaewoo.openapiservertest.forecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VillageForecastItem(

	@JsonProperty("baseDate")
	String baseDate,

	@JsonProperty("fcstTime")
	String fcstTime,

	@JsonProperty("fcstValue")
	String fcstValue,

	@JsonProperty("nx")
	int nx,

	@JsonProperty("ny")
	int ny,

	@JsonProperty("category")
	String category,

	@JsonProperty("baseTime")
	String baseTime,

	@JsonProperty("fcstDate")
	String fcstDate

) implements ForecastItem {
}