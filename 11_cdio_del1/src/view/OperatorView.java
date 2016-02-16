package view;

import java.util.Scanner;


public class OperatorView implements IOperatorView {
	
	public OperatorView(){
	}
	
	public int menuChoice(){
		
	}
	
	public int adminMenuChoice(){
		System.out.println("You are now loged in, what do you want to do?");
		System.out.println("1. Create new operator");
		System.out.println("2. Delete operator");
		System.out.println("3. View operators");
		System.out.println("4. Update opoerator");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		scan.close();
		if (choice > 0 && choice < 5)
			return choice;
		System.out.println("Invalid choice");
		return 0;
		 
	}
	
	public int getOprID(){
		
	}
	
	public String getPassword() {
		
	}
	
	public String getNewPassword(){
		
	}
	
	public double getTara(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter TARA in kg.");
		double TARA = scan.nextDouble();
		scan.close();
		return TARA;
	}
	
	public double getBrutto(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter gross in kg.");
		double brutto = scan.nextDouble();
		scan.close();
		return brutto;
		
	}
	
	public void showNetto(double Tara, double Brutto, double Netto){
		
	}
	
	public String getOprName(){
		
	}
	
	public String getCPR(){
		
	}
	
	public void showOpr (int oprId, String cpr, String name, String password){
		
	}
	
	public void showError (String error){
		
	}
	
	public int getUpdateChoice(){
	 
	}

}	
