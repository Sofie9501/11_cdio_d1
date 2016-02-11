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

}
