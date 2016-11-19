package com.espace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espace.dao.ProfileDao;

@Service ("profileManager")
public class ProfileManagerImpl implements ProfileManager {

	@Autowired
	ProfileDao profileDao;
	
	
	public List<String> getProfileByEmail(String emailId) {
	
		List<String> userDetailsList = profileDao.getProfileByEmail(emailId);
		
		return userDetailsList;
		
		
		
	}

}
