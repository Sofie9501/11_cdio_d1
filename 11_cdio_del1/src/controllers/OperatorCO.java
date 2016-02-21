package controllers;


import java.util.List;

import data.IOperatorDAO;
import data.OperatorDTO;
import utils.DALException;
import view.IOperatorView;

public class OperatorCO{
	IOperatorView view;
	IOperatorDAO data;
	AdminCO admin;

	public OperatorCO(IOperatorView view, IOperatorDAO data){
		this.view = view;
		this.data = data;
		admin = new AdminCO(data, view, this);
	}

	/***************************************************
	 * Main menu that keeps running util you press 4   *
	 ***************************************************/
	public void run(){
		while(true){
			int choice = view.menuChoice();
			switch (choice){
			case 1: adminMenu();break;
			case 2: changePassword();break;
			case 3: weighing(); break;
			case 4: return;
			}
		}

	}
	/***********************************************
	 * Admin menu only accessed after admin login  *
	 ***********************************************/
	private void adminMenu(){
		boolean log = login(true);
		int choice = 0;
		// Checks to see if login was a success
		if (log)
			choice = view.adminMenuChoice();
		else{
			view.showError("Wrong login or password");
			return;
		}
		// If the input is is not 1-4, view returns 0
		if (choice == 0)
			return;
		switch(choice){
		case 1: admin.addOperator(); break;
		case 2: admin.removeOperator(); break;
		case 3: admin.viewOperators(); break;
		case 4: admin.updateOperator(); break;
		}
	}

	private void weighing(){
		boolean log = login(false);
		if (log){
			double tara = view.getTara();
			double brutto = view.getBrutto(tara);
			view.showNetto(tara, brutto, brutto-tara);
		}
		else{
			view.showError("Wrong login or password");
			return;
		}

	}

	//Grants access to an user if he/she gives the correct ID and password.
	//If an admin is needed to login, the parameter "adminNeeded" should be true, so the
	//method can expect an admin. 
	//returns a boolean if the login succeeded. 
	private boolean login(boolean adminNeeded){
		//asks the user for the information.
		int ID = view.getOprID();
		String pass = view.getPassword();

		try{
			if(adminNeeded){
				//checks if the given password corresponds to the given ID and
				//if the given ID is an admin - if not, it returns false.  
				if(pass.equals(data.getOperator(ID).getPassword()) && 
						data.getOperator(ID).isAdmin())
					return true;
				else
					return false;
			}
			else{
				//as a normal operator-login it only checks if the password corresponds
				//to the given ID. 
				if(pass.equals(data.getOperator(ID).getPassword()))
					return true;
				else
					return false;
			}
		}
		//catches possible errors and returns false. This will make the 
		//method "adminMenu" tell the user, that something went wrong.
		catch(DALException e){
			return false;
		}
	}

	//makes it possible for an operator to change his/her password.
	private void changePassword(){
		//asks for information
		int ID = view.getOprID();
		String oldPass = view.getPassword();

		try{		
			//checks that the information is valid.
			//then asks the operator to enter a new password. 
			//the method "validatePassword" takes care of the password
			//requirements. 
			if(oldPass.equals(data.getOperator(ID).getPassword())){
				String newPass = view.getNewPassword();
				if (validatePassword(newPass)){
					data.getOperator(ID).setPassword(newPass);
				}
				else 
					view.showError("New password is not valid. - Check rules for password creation");
			}
			else
				view.showError("Wrong ID or password. ");
		}
		catch(DALException e){
			view.showError(e.getMessage());
			return;
		}
	}

	// validates password using same rules as the dtu password system
	// returns true if validated
	public boolean validatePassword(String pass){
		final int MIN_LENGTH = 6;// Minimum length 6

		// check if password is correct length and that it does not
		// contain any invalid characters
		if(pass.length() >= MIN_LENGTH && !pass.matches("(.*)[^.-_+!?=a-zA-Z0-9](.*)")){

			// 4 rules, 3 should be fulfilled
			// 1: Contain upper characters (A-Z)
			// 2: Contain lower characters (a-z)
			// 3: Contain numbers (0-9)
			// 4: Contain following character . - _ + ! ? =
			int ruleCount = 0;		// counting fulfilled rules

			if(pass.matches("(.*)[A-Z](.*)")) ruleCount++;
			if(pass.matches("(.*)[a-z](.*)")) ruleCount++;
			if(pass.matches("(.*)[0-9](.*)")) ruleCount++;
			if(pass.matches("(.*)[.\\-_+!?=](.*)")) ruleCount++;


			if(ruleCount >= 3) return true; // password verified
		}
		// password not verified
		return false;
	}


}