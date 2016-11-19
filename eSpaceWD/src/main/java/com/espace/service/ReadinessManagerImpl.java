package com.espace.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espace.dao.ReadinessDao;
import com.espace.model.Readiness;
import com.espace.model.Warehouse;

@Service ("readinessManager")
public class ReadinessManagerImpl implements ReadinessManager {

	@Autowired
	ReadinessDao readinessDao;
	
	
	public String addReadiness(String readinessElementName) {
		
		String readinessAddStatus = readinessDao.addReadiness(readinessElementName);
		
		return readinessAddStatus;
		
	}

	public String updateWarehouse(Integer readinessId, String readinessElement) {
		
		
        String readinessUpdateStatus = readinessDao.updateReadiness(readinessId, readinessElement);
		
		return readinessUpdateStatus;
		
	}

	public List<Readiness> listReadinessElements() {
	
        List<Readiness> readinessArrayList = readinessDao.listReadinessElements();
		
		return readinessArrayList;
		
		
	}

	public HashMap<String, String> getReadinessById(Integer readinessId) {
		
HashMap<String, String> readinessDetails = readinessDao.getReadinessById(readinessId);
		
		return readinessDetails;
		
	}

	public String deleteReadiness(Integer readinessId) {
		
		
        String readinessUpdateStatus = readinessDao.deleteReadiness(readinessId);
		
		return readinessUpdateStatus;
		
		
	}

}
