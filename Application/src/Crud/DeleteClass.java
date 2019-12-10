package Crud;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
public class DeleteClass {


		public void Delete() throws SQLException, ClassNotFoundException {
			MyConnection con=new MyConnection();

		Scanner s=new Scanner(System.in);
		System.out.println("Enter the register number");
		int id1=s.nextInt();
		String query1="DELETE FROM `student` WHERE ID=?";
		PreparedStatement stm1=(PreparedStatement) con.getConnection().prepareStatement(query1);
		stm1.setInt(1,id1);
		stm1.executeUpdate();
		System.out.println("Delete Successfully");

	}
	}


