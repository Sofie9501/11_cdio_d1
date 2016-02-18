package controllers;

import java.util.List;

import data.IOperatorDAO;
import data.OperatorDTO;
import utils.DALException;
import view.IOperatorView;

public class AdminCO {
	
	IOperatorDAO data;
	IOperatorView view;
	OperatorCO con;
	
	public AdminCO(IOperatorDAO data, IOperatorView view, OperatorCO con){
		this.data = data;
		this.view = view;
		this.con = con;
	}
	
	/**********************************
	 * Used to create new operators   *
	 **********************************/
	public void addOperator(){
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
	
	/**********************************************************
	 * Used to remove operators. Accessed from the admin menu *
	 **********************************************************/
	public void removeOperator(){
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
	
	/******************************
	 * Prints out all operators   *
	 ******************************/

	public void viewOperator(){
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
	/**********************************************************
	 * Used to change the name or CPR number of an operator   *
	 **********************************************************/
	
	public void updateOperator(){
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
		case 1: opr.setCpr(view.getCPR());break;
		case 2: opr.setOprName(view.getOprName());break;
		}
		
		try{
			data.updateOperator(opr);
		}catch(DALException e){
			view.showError(e.getMessage());
		}

	}

	//This method generates a password, with random chars in pre specified categories. Length determined by "passLength" variable 
	private String genPassword(int passLength) {

		String password = ""; // hold the password to be generated
		
		String chars = ".-_+!?="; // String of allowed chars.
		 
		password += (char)randInt(48, 57); //chooses a random number between 0 and 9
		password += (char)randInt(65, 90); //chooses a random capital letter between A and Z
		password += (char)randInt(97,122); //chooses a random letter between A and Z
		password += chars.charAt(randInt(0,6)); ////chooses a random char in the string "chars" 
		
		//Generates random chars after the 4. char. Between numbers, capital letters, letter, and symbols has in shown "chars"
		//It runs ,4 - password length, times.
		for(int i =4; i<passLength; i++){
			switch((int)(Math.random()*4)){
				case 0:	password += (char)randInt(48, 58); break;
				case 1:	password += (char)randInt(65, 91); break;
				case 2:	password += (char)randInt(97,123); break;
				case 3:	password += chars.charAt(randInt(0,7)); break;
			}
		}
		return password;
	}
	// finds the next available operatorid between 11 and 99
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
	private int randInt(int min, int max) {
	    return ((int)(Math.random()*(max-min)+min));
	}

}
