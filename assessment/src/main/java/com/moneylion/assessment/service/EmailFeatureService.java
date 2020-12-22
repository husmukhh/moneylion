package com.moneylion.assessment.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.moneylion.assessment.dto.EmailFeatureRequestDto;
import com.moneylion.assessment.dto.EmailFeatureResponseDto;
import com.moneylion.assessment.entities.EmailUser;
import com.moneylion.assessment.entities.Feature;
import com.moneylion.assessment.entities.EmailFeature;
import com.moneylion.assessment.repository.EmailUserRepository;
import com.moneylion.assessment.repository.FeatureRepository;

import lombok.extern.slf4j.Slf4j;

import com.moneylion.assessment.repository.EmailFeatureRepository;

@Service
@Slf4j
public class EmailFeatureService {

	private final EmailFeatureRepository emailFeatureRepo;
	private final EmailUserRepository emailUserRepo;
	private final FeatureRepository featureRepo;
	
	public EmailFeatureService(final EmailFeatureRepository userFeatureRepo,
			final EmailUserRepository emailUserRepo,
			final FeatureRepository featureRepo) {
		this.emailFeatureRepo = userFeatureRepo;
		this.emailUserRepo = emailUserRepo;
		this.featureRepo = featureRepo;
		
	}
	
	
	public EmailFeatureResponseDto  checkEmailFeatures(String email , String feature) {
		log.debug("checkEmailFeatures  method");
		Feature featureObj = featureRepo.findByFeatureName(feature).orElse(null);
		EmailUser emailUser  = emailUserRepo.findByEmail(email).orElse(null);
		
		if(featureObj != null && emailUser != null) {
			log.debug("retriving  emailFeature ....");
			EmailFeature emailFeature = emailFeatureRepo.findByFeatureIdAndEmailId(featureObj.getFeatureId(), emailUser.getEmailId()).orElse(null);
			if(emailFeature != null )
				return EmailFeatureResponseDto.builder().canAccess(emailFeature.isEnabled()).build();
			else
				return EmailFeatureResponseDto.builder().canAccess(false).build();
		}else {
			return EmailFeatureResponseDto.builder().canAccess(false).build();
		}
	}


	 public ResponseEntity<?> addUpdateEmailFeature(EmailFeatureRequestDto emailFeatureReq) {
		log.debug("addUpdateEmailFeature :::::::");
		Feature featureObj = featureRepo.findByFeatureName(emailFeatureReq.getFeature()).orElse(null);
		EmailUser emailUser  = emailUserRepo.findByEmail(emailFeatureReq.getEmail()).orElse(null);
		
		if(featureObj != null && emailUser != null) {
			EmailFeature emailFeature = emailFeatureRepo.findByFeatureIdAndEmailId(featureObj.getFeatureId(), emailUser.getEmailId()).orElse(null);
			if(emailFeature == null ) {
				log.debug("adding new emailFeature record :::::::");

				emailFeature = new EmailFeature();
				emailFeature.setEmailId(emailUser.getEmailId());
				emailFeature.setFeatureId(featureObj.getFeatureId());
				emailFeature.setEnabled(emailFeatureReq.isEnable());
				emailFeatureRepo.save(emailFeature);
				 return new ResponseEntity<>(null, HttpStatus.OK);
				
			}else if(emailFeature.isEnabled() != emailFeature.isEnabled()){
				log.debug("updating emailFeature record :::::::");
				
				emailFeature.setEnabled(emailFeature.isEnabled());
				emailFeatureRepo.save(emailFeature);
				return new ResponseEntity<>(null, HttpStatus.OK);
				
			}else {
				log.debug("nothing to do .....");
				return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
			}
			
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		}
	}
	
}
	