package Crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateClass {

	
	MyConnection con=new MyConnection();
	public void Update() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Which one you wand to Update..");
		 int eid=s.nextInt();
		System.out.println("Enter the ID");
		 int idd1=s.nextInt();
	System.out.println("Enter the name :");
	String name1=s.next();
	System.out.println("Enter the Registration ID :");
	int id1=s.nextInt();
	System.out.println("Enter the Department :");
	String dep1=s.next();
	System.out.println("Enter the Year :");
	int yr1=s.nextInt();
	System.out.println("Enter the Address :");
	String add1=s.next();
	String qry1="update student set ID =?, NAME=?,REGISTER_NUMBER=?,DEPARTMENT=?,YEAR=?,ADDRESS=? WHERE ID=?";
	PreparedStatement presmt=con.getConnection().prepareStatement(qry1);
	presmt.setInt(1,idd1);
	presmt.setString(2,name1);
	presmt.setInt(3,id1);
	presmt.setString(4,dep1);
	presmt.setInt(5,yr1);
	presmt.setString(6,add1);
	presmt.setInt(7,eid);
	presmt.executeUpdate();
	System.out.println("Update succesfull");
			
		
	}

}
