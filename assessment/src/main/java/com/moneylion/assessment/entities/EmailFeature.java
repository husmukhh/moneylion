package com.moneylion.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmailFeature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)	
	private Integer id;
	
	@Column
	private Integer featureId;

	@Column	
	private Integer emailId;
	
	@Column	
	private boolean enabled;
}
