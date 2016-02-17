package view;

import java.util.Scanner;


public class OperatorView implements IOperatorView {

	Scanner scan;
	
	public OperatorView(){
		scan = new Scanner(System.in);
	}
	
	@Override
	public void finalize(){
		scan.close();
	}

	public int menuChoice(){
		System.out.println("Menu");
		System.out.println("1. Admin menu");
		System.out.println("2. Change password");
		System.out.println("3. Weighing");
		System.out.println("4. Exit");
		int choice = Integer.parseInt(scan.nextLine());
		
		if (choice > 0 && choice < 5)
			return choice;
		System.out.println("Invalid choice");
		return 0;
		
	}

	public int adminMenuChoice(){
		System.out.println("You are now logged in. What do you want to do?");
		System.out.println("1. Create new operator");
		System.out.println("2. Delete operator");
		System.out.println("3. View operators");
		System.out.println("4. Update operator");
		int choice = Integer.parseInt(scan.nextLine());
	
		if (choice > 0 && choice < 5)
			return choice;
		System.out.println("Invalid choice");
		return 0;

	}

	//Is used when a person has to enter their OprId
	public int getOprID(){
		System.out.println("Enter OprID: ");
		int oprID = Integer.parseInt(scan.nextLine());
		return oprID;
	}

	//Is used when a person has to enter a password
	public String getPassword() {
		System.out.println("Enter password: ");
		String password = scan.nextLine();
		return password;
	}

	//is used when a person wants to change their password, it checks to make sure that the password is entered twice and that
	// the two password are the same, if they are not the same, the person has to enter the password twice again
	public String getNewPassword(){
		while (true){
			System.out.println("Enter new password: ");
			String password1 = scan.nextLine();
			System.out.println("Enter new password again: ");
			String password2 = scan.nextLine();
			if (password1.equals(password2)){
				return password1;
			}
			else{
				System.out.println("The two password are not equal, try again: ");
			}
		}
	}

	public double getTara(){
		System.out.println("Enter TARA in kg.");
		double tara = Double.parseDouble(scan.nextLine());
		return tara;
	}

	public double getBrutto(){
		System.out.println("Enter gross in kg.");
		double brutto = Double.parseDouble(scan.nextLine());
		return brutto;

	}

	public void showNetto(double Tara, double Brutto, double Netto){
		System.out.println("You have entered gross: " + Brutto + "kg.");
		System.out.println("You have entered TARA: " + Tara + "kg.");
		System.out.println("Net is: " + Netto + "kg.");
		scan.nextLine();
	}

	//Is used to get a person to enter a name
	public String getOprName(){
		System.out.println("Enter Opr name: ");
		String oprName = scan.nextLine();
		return oprName;
	}

	//Is used to get a person to enter a CPR number
	public String getCPR(){
		System.out.println("Enter CPR: ");
		String cpr = scan.nextLine();
		return cpr;
	}

	//prints the operators; OprId, cpr, name and password on the screen
	public void showOpr (int oprId, String cpr, String name, String password){
		System.out.println("Opr ID: " + oprId + " Name: " + name + " CPR: " + cpr + " Password: " + password);
	}

	// show error on the screen
	public void showError (String error){
		System.out.println(error);
		return;
	}

	public int getUpdateChoice(){
		System.out.println("1. Change cprNr");
		System.out.println("2. Change name");
		int choice = Integer.parseInt(scan.nextLine());
		if (choice > 0 && choice < 3)
			return choice;
		System.out.println("Invalid choice. ");
		return 0;

	}

}	
