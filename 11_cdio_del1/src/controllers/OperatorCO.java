package controllers;

public class OperatorCO implements IOperatorCO{

	@Override
	public boolean login(int oprID, String password, boolean adminNeeded) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String addOperator(String cpr, String oprName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(int oprID, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public double weighing(int TARA, int netto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteOperator(int oprID) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getOperator(int oprID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOperator(int oprID, int cpr, String name) {
		// TODO Auto-generated method stub

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
