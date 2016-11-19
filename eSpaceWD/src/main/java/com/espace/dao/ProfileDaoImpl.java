package com.espace.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao {


	
	String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace";
	String userId="Iqbal";
	String pwd="Iqubal5192#me";
	Connection con;
	
	public List<String> getProfileByEmail(String emailId) {
		
		

		/*
		 *
		 * 
		 * 
  Please make note of these MySQL credentials again:
  Root User: Iqbal
  Root Password: Iqubal5192#me
  ip:jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace
URL: https://chromozm-demowork.rhcloud.com/phpmyadmin/

 */
		
		
		String fullname,designation;
		Integer user_id;
		 List<String> outputList= new ArrayList<String>();
				try{
					
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection(url, userId, pwd);
					PreparedStatement prepare=con.prepareStatement("select full_name, designation_name from user_master where email_id=?");
					prepare.setString(1, emailId);

					ResultSet rs=prepare.executeQuery();
					
				      while(rs.next()){
				          //Retrieve by column name
				    	  fullname = rs.getString("full_name");
				    	  designation= rs.getString("designation_name");
				    	  outputList.add(fullname);
				    	  outputList.add(designation);
				       }
    
				       rs.close();
                  
				}
		       catch(Exception e)
		    {
		    	   System.out.println(e);
		    	    
		    }
				finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {}
					}
				}
				
				return outputList;
		
		
		
	}

}
