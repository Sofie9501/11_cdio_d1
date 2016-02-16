package view;

import java.util.Scanner;


public class OperatorView implements IOperatorView {

	public OperatorView(){
	}

	public int menuChoice(){
		System.out.println("Menu");
		System.out.println("1. Admin menu");
		System.out.println("2. Change password");
		System.out.println("3. Weighing");
		System.out.println("4. Exit");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		scan.close();
		if (choice > 0 && choice < 5)
			return choice;
		System.out.println("Invalid choice");
		return 0;

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
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter OprID: ");
		int oprID = scan.nextInt();
		scan.close();
		return oprID;
	}

	public String getPassword() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter password: ");
		String password = scan.nextLine();
		scan.close();
		return password;
	}

	public String getNewPassword(){
		Scanner scan = new Scanner(System.in);
		while (true){
			System.out.println("Enter new password: ");
			String password1 = scan.nextLine();
			System.out.println("Enter new password again: ");
			String password2 = scan.nextLine();
			scan.close();
			if (password1.equals(password2)){
				return password1;
			}
			else{
				System.out.println("The two password are not equal, try again: ");
			}
		}
	}

	public double getTara(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter TARA in kg.");
		double tara = scan.nextDouble();
		scan.close();
		return tara;
	}

	public double getBrutto(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter gross in kg.");
		double brutto = scan.nextDouble();
		scan.close();
		return brutto;

	}

	public void showNetto(double Tara, double Brutto, double Netto){
		System.out.println("You have entered gross: " + Brutto);
		System.out.println("You have entered TARA: " + Tara);
		System.out.println("Net is: " + Netto);
	}

	public String getOprName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Opr name: ");
		String oprName = scan.nextLine();
		scan.close();
		return oprName;
	}

	public String getCPR(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter CPR: ");
		String cpr = scan.nextLine();
		scan.close();
		return cpr;
	}

	public void showOpr (int oprId, String cpr, String name, String password){

	}

	public void showError (String error){
		System.out.println(error);
		return;
	}

	public int getUpdateChoice(){
		System.out.println("1. Change cprNr");
		System.out.println("2. Change name");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		scan.close();
		if (choice > 0 && choice < 3)
			return choice;
		System.out.println("Invalid choice");
		return 0;

	}

}	
