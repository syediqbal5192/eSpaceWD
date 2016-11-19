package com.espace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espace.dao.LoginDao;

@Service ("loginManager")
public class LoginManagerImpl implements LoginManager {

	@Autowired
	LoginDao loginDao;
	
	public String loginLogin(String userName, String Password) {
		
		String loginStatus = loginDao.loginLogin(userName, Password);
		
		return loginStatus;
		
	}

	public String signupLogicManager(String firstName, String designation, String emailId, String password) {
		
	String signupStatus = loginDao.signupLogicDao(firstName, designation, emailId, password);
		
		return signupStatus;
	}

}
