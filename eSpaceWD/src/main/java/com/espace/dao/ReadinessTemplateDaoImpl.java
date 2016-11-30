package com.espace.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.espace.model.Readiness;
import com.espace.model.ReadinessTemplate;
import com.espace.model.ReadinessTemplateModel;
import com.espace.model.Warehouse;

@Repository ("readinessTemplateDaoImpl")
public class ReadinessTemplateDaoImpl implements ReadinessTemplateDao {

	@Autowired
	ReadinessDao readinessDao;
	
	
	Connection con;
	PreparedStatement prepare;			
	ResultSet res;
	
	public ReadinessTemplateDaoImpl() throws ClassNotFoundException, SQLException
	{
	String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace?autoReconnect=true";
	String userId="Iqbal";
	String pwd="Iqubal5192#me";
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url, userId, pwd);
	}
	

	public List<ReadinessTemplate> listReadinessElements(Integer salesPipeLine_Id) {
		
		

		Integer readinessTemplateId;
		String companyName;
		Integer salesPipeLineId;
		String readiness_element_name;
		String readinessElementQuantity;
		String ownerName;
		String readinessElementStatus;
		Date date;
		Date taskEndDate;
		String isDeletedValue;
		 	
		//isDeleted
		String isDeleted="No";
		List<ReadinessTemplate> readinessElementsArrayList=new ArrayList<ReadinessTemplate>();
		ReadinessTemplate readinessTemplate = null;
		
		try{		        	
			//prepare=con.prepareStatement("select rt_id,company_name,sp_id,re_id,quantity,owner_name,readiness_element_status,start_end,end_date from readiness_template where sp_id=?");
			
			prepare=con.prepareStatement("select rt_r,company_name,sp_id,quantity,owner_name,readiness_element_status,start_end,end_date,re_name,isDeleted from readiness_templateR where sp_id=? and isDeleted=?");
			prepare.setInt(1, salesPipeLine_Id);
			prepare.setString(2,isDeleted);
			res=prepare.executeQuery();
		
			SimpleDateFormat sc=new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sc2=new SimpleDateFormat("yyyy-MM-dd");
			while(res.next())
			{
				readinessTemplateId = res.getInt("rt_r");
				companyName = res.getString("company_name");
				salesPipeLineId = res.getInt("sp_id");
				readiness_element_name = res.getString("re_name");
				readinessElementQuantity = res.getString("quantity");
				ownerName = res.getString("owner_name");
				readinessElementStatus = res.getString("readiness_element_status");
				date = res.getDate("start_end");
				taskEndDate =  res.getDate("end_date");
				isDeletedValue = res.getString("isDeleted");
				
				String newStartDate = sc.format(date);	
				String newEndDate = sc.format(taskEndDate);	
				String newStartDate2 = sc2.format(date);	
				String newEndDate2 = sc2.format(taskEndDate);	
				
				readinessTemplate = new ReadinessTemplate();
				
				readinessTemplate.setReadinessTemplateId(readinessTemplateId);
				readinessTemplate.setCompanyName(companyName);
				readinessTemplate.setSalesPipeLineId(salesPipeLineId);
				readinessTemplate.setReadinessName(readiness_element_name);
				readinessTemplate.setReadinessElementQuantity(readinessElementQuantity);
				readinessTemplate.setOwnerName(ownerName);
				readinessTemplate.setReadinessElementStatus(readinessElementStatus);
				readinessTemplate.setTaskStartDate(newStartDate);
				readinessTemplate.setTaskEndDate(newEndDate);
				readinessTemplate.setTaskStartDateAct(newStartDate2);
				readinessTemplate.setTaskEndDateAct(newEndDate2);
				readinessTemplate.setIsDeleted(isDeletedValue);
			
				
				readinessElementsArrayList.add(readinessTemplate);
				
				
			}

            res.close();			
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		/*finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}*/ 
			
		return readinessElementsArrayList;
		
		
		
	}
	public String addReadinessTemplate(String valueOfReadinessCompanyName, Integer valueOfReadinessSalesPipeLineId,
			Integer valueOfReadinessId, Double valueOfReadinessQuantity, String valueOfReadinessOwnerName,
			String valueOfReadinessElementStatus, Date valueOfReadinessStartDate, Date valueOfReadinessEndDate) {
		
		
		//Converting util Date to sql Date
		
	    java.sql.Date startDate = new java.sql.Date(valueOfReadinessStartDate.getTime());
	    java.sql.Date endDate = new java.sql.Date(valueOfReadinessEndDate.getTime());
	
	    String isAdded = "Yes";
	    
		try{
					
					String insertTableSQL = "INSERT INTO readiness_template (company_name,sp_id,re_id,quantity,owner_name,start_end,end_date,readiness_element_status,isAdded) VALUES(?,?,?,?,?,?,?,?,?)";
	                
					
					prepare=con.prepareStatement(insertTableSQL);
					prepare.setString(1, valueOfReadinessCompanyName);
					prepare.setInt(2, valueOfReadinessSalesPipeLineId);
					prepare.setInt(3, valueOfReadinessId);
					prepare.setDouble(4, valueOfReadinessQuantity);
					prepare.setString(5, valueOfReadinessOwnerName);
					prepare.setDate(6, startDate);
					prepare.setDate(7, endDate);
					prepare.setString(8, valueOfReadinessElementStatus);
					prepare.setString(9, isAdded);
					prepare.executeUpdate();
		
					
					return "successful";
					
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
	/*	finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}*/ 
				return "failed";
		
		
		
	}

	public HashMap<String, String> getReadinessTemplateById(Integer readinessTemplate_Id) {
		
		String readinessTemplateId;
		String companyName;
		String salesPipeLineId;
		String readinessId;
		String readinessElementQuantity;
		String ownerName;
		String readinessElementStatus;
		String taskStartDate;
		String taskEndDate;
		 
			
		 HashMap<String, String> readinessTemplate=new HashMap<String, String>();
	
		try{		        	
			
			prepare=con.prepareStatement("select distinct rt_id,company_name,sp_id,re_id,quantity,owner_name,readiness_element_status,start_end,end_date from readiness_template where rt_id=?");
			prepare.setInt(1, readinessTemplate_Id);
			res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				readinessTemplateId = String.valueOf(res.getInt("rt_id"));
				companyName = res.getString("company_name");
				salesPipeLineId = String.valueOf(res.getInt("sp_id"));
				readinessId = String.valueOf(res.getInt("re_id"));
				readinessElementQuantity = String.valueOf(res.getDouble("quantity"));
				ownerName = res.getString("owner_name");
				readinessElementStatus = res.getString("readiness_element_status");
				taskStartDate = String.valueOf(res.getDate("start_end"));
				taskEndDate = String.valueOf(res.getDate("end_date"));
				
				readinessTemplate.put("readinessTemplateId",readinessTemplateId);
				readinessTemplate.put("companyName",companyName);
				readinessTemplate.put("salesPipeLineId",salesPipeLineId);
				readinessTemplate.put("readinessId",readinessId);
				readinessTemplate.put("readinessElementQuantity",readinessElementQuantity);
				readinessTemplate.put("ownerName",ownerName);
				readinessTemplate.put("readinessElementStatus",readinessElementStatus);
				readinessTemplate.put("taskStartDate",taskStartDate);
				readinessTemplate.put("taskEndDate",taskEndDate);
			
				
				
				
			}

            res.close();			
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		/*finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}*/  
			
		return readinessTemplate;
	}






	public String updateReadinessTemplate(String valueOfReadinessCompanyName, Integer valueOfReadinessTemplateId,
			Double valueOfReadinessQuantity, String valueOfReadinessOwnerName, String valueOfReadinessElementStatus,
			Date valueOfReadinessStartDate, Date valueOfReadinessEndDate) {
		
		//Converting util Date to sql Date
		
	    java.sql.Date startDate = new java.sql.Date(valueOfReadinessStartDate.getTime());
	    java.sql.Date endDate = new java.sql.Date(valueOfReadinessEndDate.getTime());
			
		try{
			
					String insertTableSQL = "UPDATE readiness_template SET company_name=?,quantity=?,owner_name=?,start_end=?,end_date=?,readiness_element_status=?  WHERE rt_id = ?";
	                
					prepare=con.prepareStatement(insertTableSQL);
					prepare.setString(1, valueOfReadinessCompanyName);
					prepare.setDouble(2, valueOfReadinessQuantity);
					prepare.setString(3, valueOfReadinessOwnerName);
					prepare.setDate(4, startDate);
					prepare.setDate(5, endDate);
					prepare.setString(6, valueOfReadinessElementStatus);
					prepare.setInt(7, valueOfReadinessTemplateId);
					prepare.executeUpdate();
		
					
					return "successful";
					
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		/*finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}*/ 
				return "failed";
		
		
		
		
		
	}


	public String deleteReadinessTemplateById(Integer readinessId, Integer salesPipeLineId) {

		
		try{
			
			String isRemoved="Yes";
			
			
	String insertTableSQL = "UPDATE readiness_template SET isRemoved=? WHERE re_id = ? and sp_id=?";
	       
			prepare=con.prepareStatement(insertTableSQL);
			prepare.setString(1, isRemoved);
			prepare.setInt(2, readinessId);
			prepare.setInt(3, salesPipeLineId);
			prepare.executeUpdate();

			
			return "successful";
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		/*finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}  */
				
		return "failure";
	}


	public String addReadinessTemplateBulk(String valueOfReadinessCompanyName, Integer valueOfReadinessSalesPipeLineId,
			List<ReadinessTemplate> readinessArrayValue) {
		
//Converting util Date to sql Date
		
		
	
	    String isDeleted = "No";
	    
		try{
					
					String insertTableSQL = "INSERT INTO readiness_templateR (company_name,sp_id,re_name,owner_name,quantity,start_end,end_date,readiness_element_status,isDeleted) VALUES(?,?,?,?,?,?,?,?,?)";
	                
					
					prepare=con.prepareStatement(insertTableSQL);
					
					
					for (int k = 0; k < readinessArrayValue.size()-1; k++) {  
						
						prepare.setString(1, valueOfReadinessCompanyName);
						prepare.setInt(2, valueOfReadinessSalesPipeLineId);
						prepare.setString(3, readinessArrayValue.get(k).getReadinessName());
						prepare.setString(4, readinessArrayValue.get(k).getOwnerName());
						prepare.setString(5, readinessArrayValue.get(k).getReadinessElementQuantity());
						prepare.setString(6, readinessArrayValue.get(k).getTaskStartDate());
						prepare.setString(7, readinessArrayValue.get(k).getTaskEndDate());
						prepare.setString(8, readinessArrayValue.get(k).getReadinessElementStatus());
						prepare.setString(9, isDeleted);
			            prepare.addBatch();  
			        }
					
					
					
					
					prepare.executeBatch();
		
					
					return "successful";
					
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
	/*	finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}*/ 
				return "failed";
		
	}


	public String updateReadinessTemplateBulk(String valueOfReadinessCompanyName,
			Integer valueOfReadinessSalesPipeLineId, List<ReadinessTemplate> readinessArrayValue) {
		try{
			
			String insertTableSQLInsert = "INSERT INTO readiness_templateR (company_name,sp_id,re_name,owner_name,quantity,start_end,end_date,readiness_element_status,isDeleted) VALUES(?,?,?,?,?,?,?,?,?)";
            
			
			PreparedStatement preparei=con.prepareStatement(insertTableSQLInsert);
			
			
			String insertTableSQL = "UPDATE readiness_templateR SET quantity=?,owner_name=?,start_end=?,end_date=?,readiness_element_status=?, isDeleted=? WHERE sp_id=? and rt_r = ?";
	         
			
			prepare=con.prepareStatement(insertTableSQL);
			
			
			for (int k = 0; k < readinessArrayValue.size(); k++) {  
            
				if(readinessArrayValue.get(k).getReadinessTemplateId() == 0)
				{
					
				    /*DateFormat formatterStart = new SimpleDateFormat("dd-MM-yyyy");
				    Date startDateUF = formatterStart.parse(startDateString);
				      
				    DateFormat formatter = null;
			        Date convertedDate = null;

			        formatter =new SimpleDateFormat("dd-MM-yyyy");
			        convertedDate =(Date) formatter.parse(startDateString);
			        java.sql.Date startDate = new java.sql.Date(convertedDate.getTime());*/
					
					String startDateString = nvl(readinessArrayValue.get(k).getTaskStartDateAct());
					 DateFormat formatterStart3 = new SimpleDateFormat("yyyy-MM-dd");
					    Date startDateUtil = formatterStart3.parse(startDateString);
					
					java.sql.Date startDate = new java.sql.Date(startDateUtil.getTime());
					
			        
			/*	    String endDateString =readinessArrayValue.get(k).getTaskEndDateAct();
				    DateFormat formatterEnd = new SimpleDateFormat("dd-MM-yyyy");
				    Date endDateUF = formatterEnd.parse(endDateString);
				    java.sql.Date endDate = new java.sql.Date(endDateUF.getTime());*/
				    
				    
				    String endDateString = nvl(readinessArrayValue.get(k).getTaskEndDateAct());
					 DateFormat formatterStart4 = new SimpleDateFormat("yyyy-MM-dd");
					    Date endDateUtil = formatterStart4.parse(endDateString);
					
					java.sql.Date endDate = new java.sql.Date(endDateUtil.getTime());
					
				    
					preparei.setString(1, valueOfReadinessCompanyName);
					preparei.setInt(2, valueOfReadinessSalesPipeLineId);
					preparei.setString(3, readinessArrayValue.get(k).getReadinessName());
					preparei.setString(4, readinessArrayValue.get(k).getOwnerName());
					preparei.setString(5, readinessArrayValue.get(k).getReadinessElementQuantity());
					preparei.setDate(6, startDate);
					preparei.setDate(7, endDate);
					preparei.setString(8, readinessArrayValue.get(k).getReadinessElementStatus());
					preparei.setString(9, readinessArrayValue.get(k).getIsDeleted());
		            preparei.addBatch();  
				}
				else{
					
				/*	String startDateString =readinessArrayValue.get(k).getTaskStartDateAct();
				    DateFormat formatterStart = new SimpleDateFormat("yyyy-MM-dd");
				    Date startDateUF = formatterStart.parse(startDateString);
				    java.sql.Date startDate = new java.sql.Date(startDateUF.getTime());
					
				    String endDateString =readinessArrayValue.get(k).getTaskEndDateAct();
				    DateFormat formatterEnd = new SimpleDateFormat("yyyy-MM-dd");
				    Date endDateUF = formatterEnd.parse(endDateString);
				    java.sql.Date endDate = new java.sql.Date(endDateUF.getTime());*/
					
					String startDateString = nvl(readinessArrayValue.get(k).getTaskStartDateAct());
					 DateFormat formatterStart3 = new SimpleDateFormat("yyyy-MM-dd");
					    Date startDateUtil = formatterStart3.parse(startDateString);
					
					java.sql.Date startDate = new java.sql.Date(startDateUtil.getTime());
					
					String endDateString = nvl(readinessArrayValue.get(k).getTaskEndDateAct());
					 DateFormat formatterStart4 = new SimpleDateFormat("yyyy-MM-dd");
					    Date endDateUtil = formatterStart4.parse(endDateString);
					
					java.sql.Date endDate = new java.sql.Date(endDateUtil.getTime());
					
					
				prepare.setString(1, readinessArrayValue.get(k).getReadinessElementQuantity());
				prepare.setString(2, readinessArrayValue.get(k).getOwnerName());
				prepare.setDate(3, startDate);
				prepare.setDate(4, endDate);
				prepare.setString(5, readinessArrayValue.get(k).getReadinessElementStatus());
				prepare.setString(6, readinessArrayValue.get(k).getIsDeleted());
				prepare.setInt(7, valueOfReadinessSalesPipeLineId);
				prepare.setInt(8, readinessArrayValue.get(k).getReadinessTemplateId());
				
	            prepare.addBatch();  
				}
	            
	        }
			
			preparei.executeBatch();
			prepare.executeBatch();

			
			return "successful";
			
} 
		catch (Exception e) {
  e.printStackTrace();
}
/*	finally {
	if (con != null) {
		try {
			con.close();
		} catch (SQLException e) {}
	}
}*/ 
		return "failed";
	}


	public List<ReadinessTemplate> listRTClientName() {
		
		String companyName;
		Integer salesPipeLineId;
		 	
		//isDeleted
		String isDeleted="No";
		List<ReadinessTemplate> readinessElementsArrayList=new ArrayList<ReadinessTemplate>();
		ReadinessTemplate readinessTemplate = null;
		
		try{		        	
			//prepare=con.prepareStatement("select rt_id,company_name,sp_id,re_id,quantity,owner_name,readiness_element_status,start_end,end_date from readiness_template where sp_id=?");
			
			prepare=con.prepareStatement("select distinct company_name,sp_id from readiness_templateR where isDeleted=?");
			
			prepare.setString(1,isDeleted);
			res=prepare.executeQuery();
		
			
			
			while(res.next())
			{
			
				companyName = res.getString("company_name");
				salesPipeLineId = res.getInt("sp_id");
				
				
				readinessTemplate = new ReadinessTemplate();
				readinessTemplate.setCompanyName(companyName);
				readinessTemplate.setSalesPipeLineId(salesPipeLineId);
				
			
				
				readinessElementsArrayList.add(readinessTemplate);
				
				
			}

            res.close();			
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
	
			
		return readinessElementsArrayList;
		
	}
	
	
	public List<ReadinessTemplate> listReadinessElementName() {
		
		String readinessName;
		 	
		//isDeleted
		String isDeleted="No";
		List<ReadinessTemplate> readinessElementsArrayList=new ArrayList<ReadinessTemplate>();
		ReadinessTemplate readinessTemplate = null;
		
		try{		        	
			//prepare=con.prepareStatement("select rt_id,company_name,sp_id,re_id,quantity,owner_name,readiness_element_status,start_end,end_date from readiness_template where sp_id=?");
			
			prepare=con.prepareStatement("select distinct re_name from readiness_templateR where isDeleted=?");
			
			prepare.setString(1,isDeleted);
			res=prepare.executeQuery();
		
			
			
			while(res.next())
			{
				readinessName = res.getString("re_name");
				
				
				readinessTemplate = new ReadinessTemplate();
				readinessTemplate.setReadinessName(readinessName);
					
				readinessElementsArrayList.add(readinessTemplate);
				
				
			}

            res.close();			
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
		return readinessElementsArrayList;
		
		
		
		
	}


	public static String nvl(String str) {
        return (str == null) ? "" : str.trim();
    }


	public List<ReadinessTemplate> listReadinessDrillDown(String companyName) {
		

		String readiness_element_name;
		Integer readinessElementQuantity;
		
		String isDeleted="No";
		List<ReadinessTemplate> readinessElementsArrayList=new ArrayList<ReadinessTemplate>();
		ReadinessTemplate readinessTemplate = null;
		
		try{		        	
			//prepare=con.prepareStatement("select rt_id,company_name,sp_id,re_id,quantity,owner_name,readiness_element_status,start_end,end_date from readiness_template where sp_id=?");
			
			prepare=con.prepareStatement("select re_name,quantity from readiness_templateR where company_name=? and isDeleted=?");
			prepare.setString(1, companyName);
			prepare.setString(2,isDeleted);
			res=prepare.executeQuery();
		
			
			while(res.next())
			{
				
				readiness_element_name = res.getString("re_name");
				readinessElementQuantity =Integer.parseInt(res.getString("quantity"));
				
				readinessTemplate = new ReadinessTemplate();
				
				readinessTemplate.setName(readiness_element_name);
				readinessTemplate.setY(readinessElementQuantity);
				readinessTemplate.setDrilldown(true);
				
				readinessElementsArrayList.add(readinessTemplate);
				
				
			}

            res.close();			
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		 
			
		return readinessElementsArrayList;
		

		
		
	}
	
	

}
