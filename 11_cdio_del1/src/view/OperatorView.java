package view;

import java.util.InputMismatchException;
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
		while(!scan.hasNextInt()){
			System.out.println("Not correct input");
			scan.next();
		}
		int choice = scan.nextInt();
		scan.nextLine();

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
		while(!scan.hasNextInt()){
			System.out.println("Not correct input");
			scan.next();
		}
		int choice = scan.nextInt();
		scan.nextLine();

		if (choice > 0 && choice < 5)
			return choice;
		System.out.println("Invalid choice");
		return 0;

	}

	//Is used when a person has to enter their OprID
	public int getOprID(){
		String message = "Invalid ID. Should only consist of numbers. ";
		int oprID = 0;
		int x = 0;

			do{
				try{
					System.out.println("Enter operator ID: ");
					String input = scan.nextLine();

					if(input.isEmpty()){
						System.out.println(message);
					}
					else{
						oprID = Integer.parseInt(input);
						if(oprID>0){
							x = 1;
						}
						else{
							System.out.println(message);	
						}
					}
				}catch(Exception e){
					System.out.println(message);
				}
			}while(x == 0);
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
				System.out.println("The two passwords are not equal, try again: ");
			}
		}
	}
	// Returning Tara and throws an exception, if the user enters a invalid input.
	public double getTara(){
		String message = "You must enter numbers like 10 or 5.2";
		int x = 0;
		double tara=0;
		do{
			try{
				System.out.println("Enter TARA in kg.");

				String input = scan.nextLine();

				if(input.isEmpty()){
					System.out.println(message);
				}
				else{
					tara = Double.parseDouble(input);
					if(tara>0){
						x = 1;
					}
					else{
						System.out.println(message);	
					}
				}
			}catch(Exception e){
				System.out.println(message);
			}
		}while(x==0);
		return tara;
	}

	// Returning Brutto and throws an exception, if the user enters a invalid input.
	public double getBrutto(double tara){
		String message = "You must enter a number there are greater than TARA";
		int x = 0;
		double brutto=0;
		do{
			try{
				System.out.println("Enter gross in kg.");

				String input = scan.nextLine();

				if(input.isEmpty()){
					System.out.println(message);
				}
				else{
					brutto = Double.parseDouble(input);
					if(brutto>tara){
						x=1;
					}
					else{
						System.out.println(message);	
					}
				}
			}catch(Exception e){
				System.out.println(message);
			}
		}while(x==0);
		return brutto;
	}

	// calculating Net
	public void showNetto(double tara, double brutto, double netto){
		System.out.println("You have entered gross: " + brutto + "kg.");
		System.out.println("You have entered TARA: " + tara + "kg.");
		System.out.println("Net is: " + netto + "kg.");
		System.out.println("Press enter to continue");
		System.out.println("\nPress any key to return to the main menu.");
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
