package controllers;

public interface IOperatorCO {
	
	public boolean login(int oprID, String password, boolean adminNeeded);
	public String addOperator(String cpr, String oprName);
	public void changePassword(int oprID, String oldPassword, String newPassword);
	public double weighing(int TARA, int netto);
	public void deleteOperator(int oprID);
	public String getOperator(int oprID);
	public void updateOperator(int oprID, int cpr, String name);
	
}
