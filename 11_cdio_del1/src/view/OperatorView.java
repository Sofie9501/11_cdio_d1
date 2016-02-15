package view;

import java.util.Scanner;

import controllers.IOperatorCO;


public class OperatorView {
	IOperatorCO con;
	public OperatorView(IOperatorCO con){
		this.con = con;
	}
	
	public int adminMenu(){
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Make new operator");
		System.out.println("2. Change operator details");
		System.out.println("3. Delete operator");
		int val = scan.nextInt();
		scan.close();
		return val;
		
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
