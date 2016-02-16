package controllers;

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

	private boolean login(boolean adminNeeded){
		int ID = view.getOprID();
		String pass = view.getPassword();
		return false;
	}

	private void changePassword(){
	}

	private void addOperator(){
		OperatorDTO operator = new OperatorDTO();
		operator.setOprName(view.getOprName());
		operator.setCpr(view.getCPR());
		operator.setPassword(generatePassword());
		operator.setOprId(getNextOprID());
		view.showOpr(operator.getOprId(), operator.getCpr(), 
						operator.getOprName(), operator.getPassword());
	}

	private void removeOperator(){
		try{
		data.deleteOperator(data.getOperator(view.getOprID()));
		}catch(DALException e){
			view.showError(e.getMessage());
			return;
		}
		view.showError("Operator removed");
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
		OperatorDTO DTO = null;
		try{
			DTO = data.getOperator(view.getOprID());
		}catch(DALException e){
			view.showError(e.getMessage());
			return;
		}
		int choice = view.getUpdateChoice();
		if (choice == 0){
			return;
		}
		switch (choice){
		case 1: DTO.setOprName(view.getOprName());break;
		case 2: DTO.setCpr(view.getCPR());break;
		}
		try{
			data.updateOperator(DTO);
		}catch(DALException e){
			view.showError(e.getMessage());
		}
		
	}

	private String generatePassword(){
		return "01psGH.-";
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
	private int getNextOprID(){
		return 0;
	}


}