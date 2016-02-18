package controllers;

import java.util.Collections;
import java.util.List;

import data.IOperatorDAO;
import data.OperatorDTO;
import utils.DALException;
import view.IOperatorView;

public class OperatorCO{
	IOperatorView view;
	IOperatorDAO data;

	public OperatorCO(IOperatorView view, IOperatorDAO data){
		this.view = view;
		this.data = data;
	}


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

	private void weighing(){
		boolean log = login(false);
		if (log){
			double tara = view.getTara();
			double brutto = view.getBrutto();
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
					view.showError("New password is not okay. - Check rules for password creation");
			}
			else
				view.showError("Wrong ID or password. ");
		}
		catch(DALException e){
			view.showError(e.getMessage());
			return;
		}
	}

	private void addOperator(){
		int oprID = getNextOprID();
		if (oprID == -1){
			view.showError("No available operator spaces");
			return;
		}
		OperatorDTO operator = new OperatorDTO();
		operator.setOprName(view.getOprName());
		operator.setCpr(view.getCPR());
		operator.setPassword(genPassword(8));
		operator.setOprId(oprID);
		try{
			data.createOperator(operator);
		}catch (DALException e){
			view.showError(e.getMessage());
			return;
		}
		view.showOpr(operator.getOprId(), operator.getCpr(), 
				operator.getOprName(), operator.getPassword());
	}

	private void removeOperator(){
		int id = view.getOprID();
		if (id >= 11 && id <= 99){
			try{
				data.deleteOperator(data.getOperator(id));
			}catch(DALException e){
				view.showError(e.getMessage());
				return;
			}
			view.showError("Operator removed");
		}
		else{
			view.showError("Invalid Operator ID");
		}
	}


	private void viewOperator(){
		List<OperatorDTO> operators = null;
		try{
			operators = data.getOperatorList();
		}catch(DALException e){
			view.showError(e.getMessage());
			return;
		}
		for (int i = 0; i < operators.size(); i++) {
			OperatorDTO DTO = operators.get(i);
			view.showOpr(DTO.getOprId(), DTO.getCpr(), DTO.getOprName(), DTO.getPassword());
		}
	}

	private void updateOperator(){
		OperatorDTO opr;
		
		try{
			opr = data.getOperator(view.getOprID());
		}catch(DALException e){
			view.showError(e.getMessage());
			return;
		}
		
		int choice = view.getUpdateChoice();
		if (choice == 0){
			return;
		}
		
		switch (choice){
		case 1: opr.setOprName(view.getOprName());break;
		case 2: opr.setCpr(view.getCPR());break;
		}
		
		try{
			data.updateOperator(opr);
		}catch(DALException e){
			view.showError(e.getMessage());
		}

	}

	//This method generates a password, with random chars in pre specified categories. Length determined by "passLength" variable 
	private static String genPassword(int passLength) {

		char[] password = new char[passLength]; // generates an array of chars which will contain the password generated
		
		String chars = ".-_+!?="; // String of allowed chars.
		 
		password[0] = (char)randInt(48, 57); //chooses a random number between 0 and 9
		password[1] = (char)randInt(65, 90); //chooses a random capital letter between A and Z
		password[2] = (char)randInt(97,122); //chooses a random letter between A and Z
		password[3] = chars.charAt(randInt(0,6)); ////chooses a random char in the string "chars" 
		
		//Generates random chars after the 4. char. Between numbers, capital letters, letter, and symbols has in shown "chars"
		//It runs ,4 - password length, times.
		for(int i =4; i<passLength; i++){
			switch(randInt(0,3)){
				case 0:	password[i] = (char)randInt(48, 57);
				case 1:	password[i] = (char)randInt(65, 90);
				case 2:	password[i] = (char)randInt(97,122);
				case 3:	password[i] = chars.charAt(randInt(0,6));	
			}
		}
		return password.toString();
	}


	// validates password using same rules as the dtu password system
	// returns true if validated
	private boolean validatePassword(String pass){
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
			if(pass.matches("(.*)[.-_+!?=](.*)")) ruleCount++;


			if(ruleCount >= 3) return true; // password verifed
		}
		// password not verified
		return false;
	}

	private int getNextOprID(){
		List<OperatorDTO> operators;
		try{
		operators = data.getOperatorList();
		}catch(DALException e){
			// no operators in list, lets just use operatorID 11
			return 11;
		}
		
		for(int i = 0; i < operators.size(); i++){
			// first operator id is 10. which is why we check i+10
			if(i+10 != operators.get(i).getOprId())
				return i+10;
			
			// if all operators is in line, that is we have operator 10,11,12,13.
			// We need to get a new operator id which should be the size of
			// the operatorlist + 10. This is equal to the last i, plus 11
			if(i+1 == operators.size() && operators.size() != 90)
				return i+11;
			
		}
		return -1;
	}
	
	private static int randInt(int min, int max) {
	    return ((int)(Math.random()*(max-min)+min));
	}

}