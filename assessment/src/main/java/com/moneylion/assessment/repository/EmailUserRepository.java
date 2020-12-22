package com.moneylion.assessment.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.moneylion.assessment.entities.EmailUser;

@Repository
public interface EmailUserRepository  extends  PagingAndSortingRepository <EmailUser,Integer>{
	
	Optional<EmailUser> findByEmail(String email);

}
