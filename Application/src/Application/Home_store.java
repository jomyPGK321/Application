package Application;

import java.util.Scanner;

import Crud.DisplayClass;
import Crud.InsertClass;
import Crud.UpdateClass;

public class Home_store {

	public static void main(String[] args) throws ClassNotFoundException {
		Home_store ob=new Home_store();
		ob.Home_store();
	}
		public void Home_store() throws ClassNotFoundException {
			// TODO Auto-generated method stub
			
		Scanner s=new Scanner(System.in);
		int op;
			System.out.println("1.Admin\n2.Agent\n3.Exit");
			System.out.println("Enter the option");
			op=s.nextInt();	
			switch(op)
			{
			case 1:
				AdminClass obj1=new AdminClass();
				obj1.Admin();
				break;
			case 2:
				AgentClass obj2=new AgentClass();
				obj2.Agent();
				break;
			case 3:
				System.out.println("Complete the process");
				
			}
		
	}

	
	

	
		
	}


