package Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import Crud.MyConnection;

public class AdminClass {
	Store_con con2 = new Store_con();

	public void Admin() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int updateq=0;
		int newq;
		System.out.println("WELCOME");
		System.out.println("Enter the Username");
		String usnam = s.next();
		System.out.println("Enter the Password");
		String pass = s.next();
		String qry2 = "SELECT * FROM `adminlogin` WHERE `USER_NAME` =? AND `PASSWORD`=?";
		try {
			PreparedStatement pt = con2.getConnection().prepareStatement(qry2);
			pt.setString(1, usnam);
			pt.setString(2, pass);
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				System.out.println("Welcome " + usnam);
				int op;
				do {

					System.out.println("1.Add product\n2.Display\n3.Remove\n4.Update\n5.Exit");
					System.out.println("Enter the option");
					op = s.nextInt();
					switch (op) {
					case 1:
						System.out.println("Enter the ID");
						int id = s.nextInt();
						System.out.println("Enter the name :");
						String name = s.next();
						System.out.println("Enter the Quantity");
						int qty = s.nextInt();
						System.out.println("Enter the Price");
						int pz = s.nextInt();
						PreparedStatement sc = (PreparedStatement) con2.getConnection()
								.prepareStatement("insert into `addproduct`(ID,NAME,QUANTITY,PRICE) values(?,?,?,?)");
						sc.setInt(1, id);
						sc.setString(2, name);
						sc.setInt(3, qty);
						sc.setInt(4, pz);
						sc.executeUpdate();
						System.out.println("insert succesfull");
						break;
					case 2:
						Statement st = (Statement) con2.getConnection().createStatement();
						ResultSet rs2 = st.executeQuery("Select * from addproduct");
						while (rs2.next()) {
							System.out.println(rs2.getInt(1) + "\n" + rs2.getString(2) + "\n" + rs2.getInt(3) + "\n"
									+ rs2.getInt(4));

						}
						break;
					case 3:
						System.out.println("Enter the ID");
						int id1 = s.nextInt();
						String query1 = "DELETE FROM `addproduct` WHERE ID=?";
						PreparedStatement stm1 = (PreparedStatement) con2.getConnection().prepareStatement(query1);
						stm1.setInt(1, id1);
						stm1.executeUpdate();
						System.out.println("Remove Successfully");
						break;
					case 4:
						System.out.println("Welcome Admin");
						System.out.println("List Of Products");
						Statement stdi=(Statement)con2.getConnection().createStatement();
						ResultSet rsd=stdi.executeQuery("select * from addproduct");
						while(rsd.next())
						{
							System.out.println("Product id :"+rsd.getString(1)+"\n"+"Product name :"+rsd.getString(2));
							System.out.println("\n**********************************");
						}
						System.out.println("Enter the id for updating");
						int upid=s.nextInt();
						System.out.println("Enter the name of products");
						int addp=s.nextInt();
						int up=0;
						Statement st5=(Statement)con2.getConnection().createStatement();
						ResultSet rsp5=st5.executeQuery("select * from addproduct");
						while(rsp5.next())
						{
							up=rsp5.getInt(1);
							newq=rsp5.getInt(3);
							updateq=newq+addp;	
						}
						String query11="update addproduct set QUANTITY=? where ID =?";
						PreparedStatement preparestmt= (PreparedStatement) con2.getConnection().prepareStatement(query11);
						 preparestmt.setInt(1, updateq);
						 preparestmt.setInt(2, upid);
						 preparestmt.executeUpdate();
						System.out.println("Product Update successfully");
						break;

					case 5:
						Home_store back = new Home_store();
						back.Home_store();
						break;
					}
				} while (op == 1 || op == 2 || op == 3 || op == 4);
			} else {
				System.out.println("Incurrent Password or user ID");

			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

}
