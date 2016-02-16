package controllers;

import view.IOperatorView;

public class OperatorCO{
	IOperatorView view;

	public OperatorCO(IOperatorView view){
		this.view = view;
	}

	public void run(){
	}

	private void menu(){
	}

	private void adminMenu(){
		boolean log = login(true);
		int choice = 0;
		if (log)
			choice = view.adminMenuChoice();
		else{
			view.showError("Wrong login or password");
			return;
		}
		if (choice == 0)
			return;
		switch(choice){
		case 1: addOperator(); break;
		case 2: removeOperator(); break;
		case 3: viewOperator(); break;
		case 4: updateOperator(); break;
		}
	}

	private void wheighing(){
		double TARA = view.getTara();
		double brutto = view.getBrutto();
		view.showNetto(TARA, brutto, brutto-TARA);
	}

	private boolean login(boolean adminneeded){

		return false;
	}

	private void changePassword(){
	}

	private void addOperator(){
	}

	private void removeOperator(){
	}

	private void viewOperator(){
	}

	private void updateOperator(){
	}

	private void generatePassword(){
	}


	// validates password using same rules as the dtu password system
	// returns true if validated
	private boolean validatePassword(String pass){
		final int MIN_LENGTH = 6;// Minimum length 6

		// check if password is correct length and that it does not
		// contain any invalid characters
		if(pass.length() >= MIN_LENGTH && !pass.matches("(.*)[^.-_+!?=a-zA-z0-9](.*)")){

			// 4 rules, 3 should be fulfilled
			// 1: Contain upper characters (A-Z)
			// 2: Contain lower characters (a-z)
			// 3: Contain numbers (0-9)
			// 4: Contain following character . - _ + ! ? =
			int ruleCount = 0;		// counting fulfilled rules

			if(pass.matches("(.*)[A-Z](.*)")) ruleCount++;
			if(pass.matches("(.*)[a-z](.*)")) ruleCount++;
			if(pass.matches("(.*)[0-9](.*)")) ruleCount++;
			if(pass.matches("(.*)[.-_+!?=](.*)")) ruleCount++;


			if(ruleCount >= 3) return true; // password verifed
		}
		// password not verified
		return false;
	}


}