package com.devjaewoo.openapiservertest.forecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MidForecastItem (

	@JsonProperty("wf8")
	String wf8,

	@JsonProperty("wf9")
	String wf9,

	@JsonProperty("wf6Pm")
	String wf6Pm,

	@JsonProperty("wf7Pm")
	String wf7Pm,

	@JsonProperty("wf10")
	String wf10,

	@JsonProperty("wf3Pm")
	String wf3Pm,

	@JsonProperty("wf4Pm")
	String wf4Pm,

	@JsonProperty("wf5Pm")
	String wf5Pm,

	@JsonProperty("rnSt3Am")
	int rnSt3Am,

	@JsonProperty("rnSt4Am")
	int rnSt4Am,

	@JsonProperty("rnSt8")
	int rnSt8,

	@JsonProperty("rnSt10")
	int rnSt10,

	@JsonProperty("rnSt7Am")
	int rnSt7Am,

	@JsonProperty("rnSt9")
	int rnSt9,

	@JsonProperty("rnSt5Am")
	int rnSt5Am,

	@JsonProperty("rnSt6Am")
	int rnSt6Am,

	@JsonProperty("wf7Am")
	String wf7Am,

	@JsonProperty("wf3Am")
	String wf3Am,

	@JsonProperty("wf4Am")
	String wf4Am,

	@JsonProperty("wf5Am")
	String wf5Am,

	@JsonProperty("wf6Am")
	String wf6Am,

	@JsonProperty("rnSt3Pm")
	int rnSt3Pm,

	@JsonProperty("rnSt6Pm")
	int rnSt6Pm,

	@JsonProperty("rnSt7Pm")
	int rnSt7Pm,

	@JsonProperty("rnSt4Pm")
	int rnSt4Pm,

	@JsonProperty("rnSt5Pm")
	int rnSt5Pm,

	@JsonProperty("regId")
	String regId

) implements ForecastItem {
}