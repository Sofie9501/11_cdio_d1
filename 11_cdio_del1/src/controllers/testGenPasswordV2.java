package controllers;

public class testGenPasswordV2 {

	public static void main(String[] args) {
		
		
		int passwordLength = 8;
		
		for(int i=0; i<10;i++){
			System.out.println(genPassword(passwordLength));
		}
	}

	private static String genPassword(int passLength) {

		char[] password = new char[passLength];
		
		String chars = ".-_+!?=";
		 
		password[0] = (char)randInt(48, 57);
		password[1] = (char)randInt(65, 90);
		password[2] = (char)randInt(97,122);
		password[3] = chars.charAt(randInt(0,6));
		
		for(int i =4; i<passLength; i++){
			switch(randInt(0,3)){
				case 0:	password[i] = (char)randInt(48, 57);
				case 1:	password[i] = (char)randInt(65, 90);
				case 2:	password[i] = (char)randInt(97,122);
				case 3:	password[i] = chars.charAt(randInt(0,6));	
			}
		}
		return password.toString();
	}
	
	private static int randInt(int min, int max) {
	    return ((int)(Math.random()*(max-min)+min));
	}

}
