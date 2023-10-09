package com.moneylion.assessment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneylion.assessment.dto.EmailFeatureRequestDto;
import com.moneylion.assessment.dto.EmailFeatureResponseDto;
import com.moneylion.assessment.service.EmailFeatureService;

@RestController
public class UserFeatureController {

	private final EmailFeatureService emailFeatureServie;

	public UserFeatureController(EmailFeatureService userFeatureServie) {
		this.emailFeatureServie = userFeatureServie;
	}
	
	@GetMapping("/feature")
	public EmailFeatureResponseDto  checkUserFeature(@RequestParam("email") String email , @RequestParam("featureName") String featureName) {
		
		return emailFeatureServie.checkEmailFeatures(email, featureName);
	}

	@PostMapping("/feature")
	public ResponseEntity<?>  addUpdateFeature(@RequestBody final EmailFeatureRequestDto emailFeatureReq) {
		return emailFeatureServie.addUpdateEmailFeature(emailFeatureReq);
	}
}
