package com.moneylion.assessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailFeatureResponseDto {

	@JsonProperty("canAccess")
	boolean canAccess;
}
