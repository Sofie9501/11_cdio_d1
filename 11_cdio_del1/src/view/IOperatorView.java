package view;

public interface IOperatorView {

	public int menuChoice();
	public int adminMenuChoice();
	public int getOprID();
	public String getPassword();
	public String getNewPassword();
	public double getTara();
	public double getBrutto();
	public void showNetto(double tara, double brutto, double netto);
	public String getOprName();
	public String getCPR();
	public void showOpr (int oprId, String cpr, String name, String password);
	public void showError (String error);
	public int getUpdateChoice();
}
