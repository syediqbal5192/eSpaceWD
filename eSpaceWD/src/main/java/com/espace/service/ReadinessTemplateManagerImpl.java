package com.espace.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espace.dao.ReadinessTemplateDao;
import com.espace.model.Readiness;
import com.espace.model.ReadinessTemplate;
import com.espace.model.ReadinessTemplateModel;
import com.espace.model.Warehouse;

@Service ("readinessManagerTemplate")
public class ReadinessTemplateManagerImpl implements ReadinessTemplateManager {

	@Autowired
	ReadinessTemplateDao readinessTemplateDao;

	public String addReadinessTemplate(String valueOfReadinessCompanyName, Integer valueOfReadinessSalesPipeLineId,
			Integer valueOfReadinessId, Double valueOfReadinessQuantity, String valueOfReadinessOwnerName,
			String valueOfReadinessElementStatus, Date valueOfReadinessStartDate, Date valueOfReadinessEndDate) {
		
        
		String readinessTemplateStatus = readinessTemplateDao.addReadinessTemplate(valueOfReadinessCompanyName, valueOfReadinessSalesPipeLineId, valueOfReadinessId, valueOfReadinessQuantity, valueOfReadinessOwnerName, valueOfReadinessElementStatus, valueOfReadinessStartDate, valueOfReadinessEndDate);
		
		return readinessTemplateStatus;
	}
	


	public List<ReadinessTemplate> listReadinessTemplate(Integer salesPipeLineId) {
		
		 List<ReadinessTemplate> readinessArrayList = readinessTemplateDao.listReadinessElements(salesPipeLineId);
			
			return readinessArrayList;
		
	}

	public HashMap<String, String> getReadinessTemplateDetaisById(Integer readinessTemplateId) {
			
			HashMap<String, String> readinessDetails = readinessTemplateDao.getReadinessTemplateById(readinessTemplateId);
					
					return readinessDetails;
					
				
	}

	public String updateReadinessTemplate(String valueOfReadinessCompanyName, Integer valueOfReadinessTemplateId,
			Double valueOfReadinessQuantity, String valueOfReadinessOwnerName, String valueOfReadinessElementStatus,
			Date valueOfReadinessStartDate, Date valueOfReadinessEndDate) {
		
		
		 
		String readinessTemplateStatus = readinessTemplateDao.updateReadinessTemplate(valueOfReadinessCompanyName, valueOfReadinessTemplateId, valueOfReadinessQuantity, valueOfReadinessOwnerName, valueOfReadinessElementStatus, valueOfReadinessStartDate, valueOfReadinessEndDate);
		
		return readinessTemplateStatus;
		
	}


	public String deleteReadinessTemplateById(Integer readinessId, Integer salesPipeLineId) {
		
		 
			String readinessTemplateStatus = readinessTemplateDao.deleteReadinessTemplateById(readinessId, salesPipeLineId);
			return readinessTemplateStatus;
		
	}


	public String addReadinessTemplateBulk(String valueOfReadinessCompanyName, Integer valueOfReadinessSalesPipeLineId,List<ReadinessTemplate> readinessArrayValue) {
		
		String bulkAdditionStatus = readinessTemplateDao.addReadinessTemplateBulk(valueOfReadinessCompanyName, valueOfReadinessSalesPipeLineId, readinessArrayValue);
		
		return bulkAdditionStatus;
		
	}


	public String updateReadinessTemplateBulk(String valueOfReadinessCompanyName,
			Integer valueOfReadinessSalesPipeLineId, List<ReadinessTemplate> readinessArrayValue) {
	
		String bulkAdditionStatus = readinessTemplateDao.updateReadinessTemplateBulk(valueOfReadinessCompanyName, valueOfReadinessSalesPipeLineId, readinessArrayValue);
		
		return bulkAdditionStatus;
	}


	public List<ReadinessTemplate> listRTClientName() {

		 List<ReadinessTemplate> readinessArrayList = readinessTemplateDao.listRTClientName();
			
			return readinessArrayList;
	}


	public List<ReadinessTemplate> listReadinessElementName() {
		
		 List<ReadinessTemplate> readinessArrayList = readinessTemplateDao.listReadinessElementName();
			
			return readinessArrayList;
		
	}



	public List<ReadinessTemplate> listReadinessDrillDown(String warehouseName) {
		List<ReadinessTemplate> dashboardIconInfoList = readinessTemplateDao.listReadinessDrillDown(warehouseName);
		
		return dashboardIconInfoList;
	}

	
	
	

	
	
}
