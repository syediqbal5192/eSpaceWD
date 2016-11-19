package com.espace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;



@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {


	Connection con;
	PreparedStatement prepare;			
	ResultSet res;
	
	public LoginDaoImpl() throws ClassNotFoundException, SQLException
	{
	String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace";
	String userId="Iqbal";
	String pwd="Iqubal5192#me";
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url, userId, pwd);
	}
	
	
	
	public String loginLogin(String userName, String Password) {
		
		Connection connection = null;
		
		
				try{
					
					//connection = dataSource.getConnection();
					
					PreparedStatement prepare=con.prepareStatement("select * from user_master where email_id=? and password=?");
					prepare.setString(1, userName);
					prepare.setString(2, Password);

					ResultSet rs=prepare.executeQuery();
				 
				      
					if(rs.next())
					{
						return "successful";
						
					}
				}
		       catch(Exception e)
		    {
		    	   System.out.println(e);
		    	    
		    } finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
				
				return "failure";

	}

	public String signupLogicDao(String firstName, String designation, String emailId, String password) {
		
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
		
		Connection con = null;
		
		PreparedStatement prepare;		
		
		try{
					
			        //con = dataSource.getConnection();
					String insertTableSQL = "INSERT INTO user_master (full_name, email_id, password, designation_name ) VALUES(?,?,?,?)";
                    prepare=con.prepareStatement(insertTableSQL);
					prepare.setString(1, firstName);
					prepare.setString(2, emailId);
					prepare.setString(3, password);
					prepare.setString(4, designation);
					prepare.executeUpdate();
		
					
					return "successful";
					
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		} 
				return "failed";
		
		
		
	}

}
