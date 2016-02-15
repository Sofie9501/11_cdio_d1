package view;

public interface IOperatorView {

	public int menuChoice();
	public int adminMenuChoice();
	public int getOperatorID();
	public String getPassword();
	public String getNewPassword();
	public double getTara();
	public double getBrutto();
	public void showNetto();
	public String getOperatorName();
	public String getCPR();
	public void showOperator (int oprId, String cpr, String name, String password);
	public void showError (String error);
	public int getUpdateChoice();
}
