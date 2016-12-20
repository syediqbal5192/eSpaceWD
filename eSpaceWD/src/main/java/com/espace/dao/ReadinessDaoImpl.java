package com.espace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.espace.model.Readiness;
import com.espace.model.ReadinessTemplateModel;
import com.espace.model.Warehouse;


@Repository ("readinessDaoImpl")
public class ReadinessDaoImpl implements ReadinessDao {

	PreparedStatement prepare;	
	ResultSet res;
	Connection con;
	
	public ReadinessDaoImpl() throws ClassNotFoundException, SQLException
	{
	String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace?autoReconnect=true";
	String userId="Iqbal";
	String pwd="Iqubal5192#me";
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url, userId, pwd);
	}
	
	
	
	public String addReadiness(String readinessElementName) {

				
		String isActive="Yes";
		String isDeleted="No";
		
		try{
					
			
					String insertTableSQL = "INSERT INTO readiness_elements_details (readiness_element_name,isActive, isDeleted) VALUES(?,?,?)";
                    
					
					prepare=con.prepareStatement(insertTableSQL);
					prepare.setString(1, readinessElementName);
					prepare.setString(2, isActive);
					prepare.setString(3, isDeleted);
					prepare.executeUpdate();
		
					
					return "successful";
					
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }

				return "failed";
		
	}

	public String updateReadiness(Integer readinessId, String readinessElement) {
		
		
		try{
			
			
			
         	String insertTableSQL = "UPDATE readiness_elements_details SET readiness_element_name=? WHERE re_id = ?";
	       
			
			prepare=con.prepareStatement(insertTableSQL);
			prepare.setString(1, readinessElement);
			prepare.setInt(2, readinessId);
			prepare.executeUpdate();

			
			return "successful";
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
				return "failed";

		
	}

	public List<Readiness> listReadinessElements() {
		
		

		Integer re_id;
		String readiness_element_name;
		 
		
		List<Readiness> readinessElementsArrayList=new ArrayList<Readiness>();
		Readiness readiness = null;
		
		try{		
			
			
			prepare=con.prepareStatement("select re_id,readiness_element_name from readiness_elements_details where isActive='Yes' and isDeleted='No'");
            res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				re_id=res.getInt("re_id");
				readiness_element_name = res.getString("readiness_element_name");
				
				readiness = new Readiness();
				readiness.setRe_id(re_id);
				readiness.setReadiness_element_name(readiness_element_name);
				
				readinessElementsArrayList.add(readiness);
				
				
			}

            res.close();			
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		 
		
			
		return readinessElementsArrayList;
		
		
		
		
		
	}


	public HashMap<String, String> getReadinessById(Integer readinessId) {
		
	
		String re_id;
		String readiness_element_name;
			
		
		 HashMap<String, String> outputList= new HashMap<String, String>();
				try{
					
					
					
					prepare=con.prepareStatement("select readiness_element_name from readiness_elements_details where re_id=?");
		            prepare.setInt(1, readinessId);

					 res=prepare.executeQuery();
					
				      while(res.next()){
				          //Retrieve by column name
				    	  re_id = String.valueOf(readinessId);
				    	  readiness_element_name = res.getString("readiness_element_name");
				    	 
				    	  
						  outputList.put("re_id", re_id);
				    	  outputList.put("readiness_element_name", readiness_element_name);
				    	  
				       }
    
				       res.close();
                  
				}
		       catch(Exception e)
		    {
		    	   System.out.println(e);
		    	    
		    }
			 
				
				return outputList;
	}

	public String deleteReadiness(Integer readinessId) {

	
		
		try{
			
			String isActive="No";
			String isDeleted="Yes";		
			
			
	String insertTableSQL = "UPDATE readiness_elements_details SET isActive=?, isDeleted=?  WHERE re_id = ?";
	       
			prepare=con.prepareStatement(insertTableSQL);
			prepare.setString(1, isActive);
			prepare.setString(2, isDeleted);
			prepare.setInt(3, readinessId);
			prepare.executeUpdate();

			
			return "successful";
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		  
				
		return "failure";
	}
	

}
