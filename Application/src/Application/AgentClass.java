package Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class AgentClass {
	Store_con con2 = new Store_con();

	public void Agent() throws ClassNotFoundException {

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("WELCOME");
		System.out.println("Enter the Username");
		String usnam = s.next();
		System.out.println("Enter the Password");
		String pass = s.next();
		int q = 0;
		double price;
		int bal = 0;
		String qry2 = "SELECT * FROM `agentlogin` WHERE `USERNAME` =? AND `PASSWORD`=?";
		try {
			PreparedStatement pt = con2.getConnection().prepareStatement(qry2);
			pt.setString(1, usnam);
			pt.setString(2, pass);
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				System.out.println("Welcome " + usnam);
				int op;
				do {
					System.out.println("1.BuySell\n2.View Products\n3.Home Page");
					System.out.println("Enter the option");
					op = s.nextInt();
					switch (op) {
					case 1:
						String yes = null;
						do {
							System.out.println("Enter the ID");
							int id21 = s.nextInt();
							System.out.println("Enter the Quantity");
							int qty = s.nextInt();
							int id22 = 0;
							Statement st2 = (Statement) con2.getConnection().createStatement();
							ResultSet rsp12 = st2.executeQuery("select * from addproduct");
							while (rsp12.next()) {
								id22 = rsp12.getInt(1);
								if (id22 == id21) {
									 q = rsp12.getInt(3);
									 price = rsp12.getInt(4);
									System.out.println("Your price Total is" + (price * qty));
									bal = q - qty;
								}
							}
							System.out.println("Continue with order");
							yes = s.next();
							if (yes.contentEquals("yes")) {
								String query1 = "update addproduct set QUANTITY =? where ID=?";
								PreparedStatement stm1 = (PreparedStatement) con2.getConnection()
										.prepareStatement(query1);
								stm1.setInt(1, bal);
								stm1.setInt(2, id21);
								stm1.executeUpdate();
								System.out.println("Thank you for purchaising");
							}
						} while (yes.contentEquals("no"));
						break;
					case 2:

						Statement st1 = (Statement) con2.getConnection().createStatement();
						ResultSet rs1 = st1.executeQuery("Select * from addproduct");
						while (rs1.next()) {
							System.out.println(rs1.getInt(1) + "\n" + rs1.getString(2) + "\n" + rs1.getInt(3) + "\n" + rs1.getInt(4));

						}
						break;

					case 3:
						Home_store back = new Home_store();
						back.Home_store();
						break;

					}
				} while (op == 1 || op == 2 || op == 3);

			} else {
				System.out.println("Incurrent Password or user ID");

			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	private Statement executeQuery(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}