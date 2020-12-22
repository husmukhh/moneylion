package com.moneylion.assessment.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.moneylion.assessment.entities.EmailFeature;

@Repository
public interface EmailFeatureRepository  extends  PagingAndSortingRepository <EmailFeature,Integer>{
	
	Optional<EmailFeature>  findByFeatureIdAndEmailId(Integer featureId, Integer emailId);

}
