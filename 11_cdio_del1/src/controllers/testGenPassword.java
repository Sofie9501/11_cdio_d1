package controllers;

import java.util.Random;

public class testGenPassword {

	public static void main(String[] args) {
		
		int passwordLength = 12;
		
		for(int i=0; i<10;i++){
			System.out.println(genPassword(passwordLength));
		}

	}

	private static String genPassword(int passLength) {
		int ascii;
		String password = "";
		
		int counter1=0,counter2=0,counter3=0,counter4=0;
		int countTotal = 0;
		
		while(countTotal < passLength){
			ascii = randInt();
			if(((ascii >= 33 && ascii <= 47) || (ascii >= 58 && ascii <= 64) || (ascii >= 91 && ascii <= 96) || (ascii >= 123 && ascii <= 126)) && counter1 < 3){
				password = ((char)ascii) + password;
				counter1++;
			}
			if(ascii >= 48 && ascii <= 57 && counter2 < 3){
				password = ((char)ascii) + password;
				counter2++;
			}
			if(ascii >= 65 && ascii <= 90 && counter3 < 3){
				password = ((char)ascii) + password;
				counter3++;
			}
			if(ascii >= 97 && ascii <= 122 && counter4 < 3){
				password = ((char)ascii) + password;
				counter4++;
			}
		//	System.out.println(countTotal);
			countTotal = counter1 + counter2 + counter3 + counter4; 
		}
				
		return password;
	}
	
	private static int randInt() {

		int randomNum;
		
		randomNum = (int) Math.round((Math.random()*1000));

	    return randomNum;
	}

}
