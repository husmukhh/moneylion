package com.moneylion.assessment.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.moneylion.assessment.entities.Feature;

@Repository
public interface FeatureRepository   extends  PagingAndSortingRepository <Feature,Integer>{
	
	Optional<Feature> findByFeatureName(String featureName);

}
