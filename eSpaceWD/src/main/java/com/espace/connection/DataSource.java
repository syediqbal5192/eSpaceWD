package com.espace.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace";
		String userId="Iqbal";
		String pwd="Iqubal5192#me";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url, userId, pwd);
		
		return connection;
		
	}
	
	
}
