package Crud;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MyConnection {
	

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//1.register the driver . driver.link
		Class.forName("com.mysql.jdbc.Driver");//register a driver //class.forName() 
		Connection con=null;//connection object
		//2. create connection
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
		//object=         class        .methordm    (API:database:/server name:pport no./DB=username,password
		if(con!=null)//connection checking
		{
		return con;	
		}
		else
		{
			return null;
		}
}

	
	
	

	
	}
