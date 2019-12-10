package Crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DisplayClass {

	MyConnection con=new MyConnection();
	public void Display() throws ClassNotFoundException, SQLException {
		Statement st=(Statement) con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("Select * from Student");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getInt(3)+"\n"+rs.getString(4)+"\n"+rs.getInt(5)+"\n"+rs.getString(6));
			
		}		
	}

}
