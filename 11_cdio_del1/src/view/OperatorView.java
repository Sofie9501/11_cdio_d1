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
		double TARA = 0;
		double brutto = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter TARA in kg." );
		TARA = scan.nextDouble();
		System.out.println("Enter gross in kg.");
		brutto = scan.nextDouble();
		System.out.println("The net is " + con.weighing(TARA, brutto));
		
	}
	private void exit(){
		return;
	}
	private void addOperator(){
		
	}
}	
