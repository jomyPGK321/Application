package Application;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class Store_con {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");//register a driver //class.forName() 
		Connection con2=null;//connection object
		//2. create connection
		con2=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Store_Keeper","root","");
		//object=         class        .methordm    (API:database:/server name:pport no./DB=username,password
		if(con2!=null)//connection checking
		{
		return con2;	
		}
		else
		{
			return null;
		}
	}

}
