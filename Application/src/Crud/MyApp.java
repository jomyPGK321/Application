package Crud;

import java.sql.SQLException;
import java.util.Scanner;

public class MyApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
int op;
do
{
	System.out.println("1.insert\n2.display\n3.Update\n4.Delete\n5.Login\n6.Exit");
	System.out.println("Enter the option");
	op=s.nextInt();	
	switch(op)
	{
	case 1:
		InsertClass obj1=new InsertClass();
		obj1.Insert();
		break;
	case 2:
		DisplayClass obj2=new DisplayClass();
		obj2.Display();
		break;
	case 3:
		UpdateClass obj3=new UpdateClass();
		obj3.Update();
		break;
	case 4:
		DeleteClass obj4=new DeleteClass();
		obj4.Delete();
		break;
	case 5:
		LoginClass obj5=new LoginClass();
		obj5.Login();
		break;
	case 6:
		System.exit(0);
	}
}
while(op==1 || op==2 || op==3 || op==4 ||op==5 || op==6);
	
	}
}