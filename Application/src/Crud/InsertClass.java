package Crud;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsertClass {

	
	

	public void Insert() throws SQLException, ClassNotFoundException {
		MyConnection con=new MyConnection();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the ID");
		int idd=s.nextInt();
	System.out.println("Enter the name :");
	String name=s.next();
	System.out.println("Enter the Registration ID :");
	int id=s.nextInt();
	System.out.println("Enter the Department :");
	String dep=s.next();
	System.out.println("Enter the Year :");
	int yr=s.nextInt();
	System.out.println("Enter the Address :");
	String add=s.next();
	PreparedStatement sc=(PreparedStatement)con.getConnection().prepareStatement("insert into Student(ID,NAME,REGISTER_NUMBER,DEPARTMENT,YEAR,ADDRESS) values(?,?,?,?,?,?)");
	sc.setInt(1,idd);
	sc.setString(2,name);
	sc.setInt(3,id);
	sc.setString(4,dep);
	sc.setInt(5,yr);
	sc.setString(6,add);
	sc.executeUpdate();
	System.out.println("insert succesfull");
	}

}
