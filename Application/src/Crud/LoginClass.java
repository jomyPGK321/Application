package Crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginClass {

	MyConnection con=new MyConnection();
	public void Login() throws ClassNotFoundException {
		Scanner s=new Scanner(System.in);
		System.out.println("WELCOME");
		System.out.println("Enter the Username");
		String usnam=s.next();
		System.out.println("Enter the Password");
		String pass=s.next();
		String qry2="SELECT * FROM `student` WHERE `NAME` =? AND `REGISTER_NUMBER`=?";
		try
		{
			PreparedStatement pt=con.getConnection().prepareStatement(qry2);
			pt.setString(1,usnam);
			pt.setString(2,pass);
			ResultSet rs=pt.executeQuery();
			if(rs.next())
			{
				System.out.println("Welcome "+usnam);
			}
			else
			{
				System.out.println("Incurrent Password or user ID");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
	}

}
