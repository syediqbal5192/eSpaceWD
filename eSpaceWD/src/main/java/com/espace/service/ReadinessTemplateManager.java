package com.espace.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.espace.model.Readiness;
import com.espace.model.ReadinessTemplate;
import com.espace.model.ReadinessTemplateModel;
import com.espace.model.Warehouse;

public interface ReadinessTemplateManager {

	    public String addReadinessTemplate(String valueOfReadinessCompanyName,Integer valueOfReadinessSalesPipeLineId,Integer valueOfReadinessId,Double valueOfReadinessQuantity, String valueOfReadinessOwnerName,String valueOfReadinessElementStatus,Date valueOfReadinessStartDate,Date valueOfReadinessEndDate);
	   
	    public String addReadinessTemplateBulk(String valueOfReadinessCompanyName,Integer valueOfReadinessSalesPipeLineId,List<ReadinessTemplate> readinessArrayValue);
	    
	    public String updateReadinessTemplateBulk(String valueOfReadinessCompanyName,Integer valueOfReadinessSalesPipeLineId,List<ReadinessTemplate> readinessArrayValue);

		public String updateReadinessTemplate(String valueOfReadinessCompanyName,Integer valueOfReadinessTemplateId,Double valueOfReadinessQuantity, String valueOfReadinessOwnerName,String valueOfReadinessElementStatus,Date valueOfReadinessStartDate,Date valueOfReadinessEndDate);
		
		public List<ReadinessTemplate> listReadinessTemplate(Integer salesPipeLineId);

		public List<ReadinessTemplate> listRTClientName();
		
		public List<ReadinessTemplate> listReadinessElementName();
		
		public HashMap<String, String> getReadinessTemplateDetaisById(Integer readinessTemplateId);
		
		public String deleteReadinessTemplateById(Integer readinessId,Integer salesPipeLineId);
		
		public List<ReadinessTemplate> listReadinessDrillDown(String warehouseName);
		
}
