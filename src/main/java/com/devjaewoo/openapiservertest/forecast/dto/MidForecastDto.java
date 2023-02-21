package com.devjaewoo.openapiservertest.forecast.dto;

import com.devjaewoo.openapiservertest.forecast.entity.MidForecastData;
import com.fasterxml.jackson.annotation.JsonProperty;

public record MidForecastDto(

	@JsonProperty("regId")
	String regId,

	@JsonProperty("rnSt3Am")
	int rnSt3Am,

	@JsonProperty("rnSt3Pm")
	int rnSt3Pm,

	@JsonProperty("rnSt4Am")
	int rnSt4Am,

	@JsonProperty("rnSt4Pm")
	int rnSt4Pm,

	@JsonProperty("rnSt5Am")
	int rnSt5Am,

	@JsonProperty("rnSt5Pm")
	int rnSt5Pm,

	@JsonProperty("rnSt6Am")
	int rnSt6Am,

	@JsonProperty("rnSt6Pm")
	int rnSt6Pm,

	@JsonProperty("rnSt7Am")
	int rnSt7Am,

	@JsonProperty("rnSt7Pm")
	int rnSt7Pm,

	@JsonProperty("rnSt8")
	int rnSt8,

	@JsonProperty("rnSt9")
	int rnSt9,

	@JsonProperty("rnSt10")
	int rnSt10,

	@JsonProperty("wf3Am")
	String wf3Am,

	@JsonProperty("wf3Pm")
	String wf3Pm,

	@JsonProperty("wf4Am")
	String wf4Am,

	@JsonProperty("wf4Pm")
	String wf4Pm,

	@JsonProperty("wf5Am")
	String wf5Am,

	@JsonProperty("wf5Pm")
	String wf5Pm,

	@JsonProperty("wf6Am")
	String wf6Am,

	@JsonProperty("wf6Pm")
	String wf6Pm,

	@JsonProperty("wf7Am")
	String wf7Am,

	@JsonProperty("wf7Pm")
	String wf7Pm,

	@JsonProperty("wf8")
	String wf8,

	@JsonProperty("wf9")
	String wf9,

	@JsonProperty("wf10")
	String wf10

) implements ForecastItem {
	
	public MidForecastData toEntity() {
		return MidForecastData.builder()
				.rnSt3Am(rnSt3Am)
				.rnSt3Am(rnSt3Pm)
				.rnSt4Am(rnSt4Am)
				.rnSt4Am(rnSt4Pm)
				.rnSt5Am(rnSt5Am)
				.rnSt5Am(rnSt5Pm)
				.rnSt6Am(rnSt6Am)
				.rnSt6Am(rnSt6Pm)
				.rnSt7Am(rnSt7Am)
				.rnSt7Am(rnSt7Pm)
				.rnSt8(rnSt8)
				.rnSt9(rnSt9)
				.rnSt10(rnSt10)

				.wf3Am(wf3Am)
				.wf3Am(wf3Pm)
				.wf4Am(wf4Am)
				.wf4Am(wf4Pm)
				.wf5Am(wf5Am)
				.wf5Am(wf5Pm)
				.wf6Am(wf6Am)
				.wf6Am(wf6Pm)
				.wf7Am(wf7Am)
				.wf7Am(wf7Pm)
				.wf8(wf8)
				.wf9(wf9)
				.wf10(wf10)

				.build();
	}
}