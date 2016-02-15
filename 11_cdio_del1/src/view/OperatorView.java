package view;

import java.util.Scanner;

import controllers.IOperatorCO;
import controllers.OperatorCO;

public class OperatorView {
	IOperatorCO con = new OperatorCO();
	public OperatorView(IOperatorCO con){
		this.con = con;
	}
	
	private void adminMenu(){
		
	}
	
	private void changePassword(){
		
	}
	private void weighing(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter TARA in kg." );
		double TARA = scan.nextDouble();
		System.out.println("Enter gross in kg.");
		double brutto = scan.nextDouble();
		scan.close();
		System.out.println("The net is " + con.weighing(TARA, brutto));
		
	}
	private void exit(){
		return;
	}
	private void addOperator(){
		
	}
}	
