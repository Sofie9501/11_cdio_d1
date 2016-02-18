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

	//Is used when a person has to enter their OprID
	public int getOprID(){
		String message = "Invalid ID. Should only consist of numbers. ";
		int oprID = 0;
		
		//This loop continues until the operator has entered a valid ID.
		while(true){
			System.out.println("Enter operator ID: ");
			
			try{
				String input = scan.nextLine();
				
				//Checks if the input is empty and gives a message.
				if(input.isEmpty()){
					System.out.println(message);
					break;
				}
				else{
					//If not, the String will be parsed and returned.
					oprID = Integer.parseInt(input);
					return oprID;
				}

				//Catches the exception that occurs if the operator enters invalid
				//ID. For example a mix of letters and numbers. 
			}catch(NumberFormatException e){
				System.out.println(message);
			}
		}
		return 0;
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
				System.out.println("The two passwords are not equal, try again: ");
			}
		}
	}

	public double getTara(){
		double tara=0;
		do{
			System.out.println("Enter TARA in kg.");
			tara = Double.parseDouble(scan.nextLine());
			if(tara<=0){
				System.out.println("TARA must be greater than 0\n");
			}
		}while(tara<=0);
		return tara;
	}

	public double getBrutto(double tara){
		double brutto=0;
		do{
			System.out.println("Enter gross in kg.");
			brutto = Double.parseDouble(scan.nextLine());
			if(brutto <= tara){
				System.out.println("Brutto must be greater than TARA\n");
			}
		}while(brutto <= tara);
		return brutto;

	}

	public void showNetto(double tara, double brutto, double netto){
		System.out.println("You have entered gross: " + brutto + "kg.");
		System.out.println("You have entered TARA: " + tara + "kg.");
		System.out.println("Net is: " + netto + "kg.");
		scan.nextLine();
	}

	//Is used to get a person to enter a name
	public String getOprName(){
		System.out.println("Enter Operator name: ");
		String oprName = scan.nextLine();
		return oprName;
	}

	//Is used to get a person to enter a CPR number
	public String getCPR(){
		while(true){
			System.out.println("Enter CPR in the form xxxxxx-xxxx: ");
			String cpr = scan.nextLine();
			if(cpr.matches("[0-3][0-9][0-1][0-9]\\d{2}-\\d{4}?[^0-9]*"))
				return cpr;
			else
				System.out.println("Invalid CPR, try again:");
		}
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
		System.out.println("1. Change CPR-Nr");
		System.out.println("2. Change name");
		int choice = Integer.parseInt(scan.nextLine());
		if (choice > 0 && choice < 3)
			return choice;
		System.out.println("Invalid choice. ");
		return 0;

	}

}	
