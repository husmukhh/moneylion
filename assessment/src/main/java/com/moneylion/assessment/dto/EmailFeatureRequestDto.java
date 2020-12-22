package com.moneylion.assessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmailFeatureRequestDto {
	
	@JsonProperty("feature")
	private String feature;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("enable")
	private boolean enable;

}
