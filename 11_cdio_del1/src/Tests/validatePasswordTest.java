package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.OperatorCO;
import data.OperatorData;
import view.OperatorView;

public class validatePasswordTest {

	@Test
	public void test() {
		OperatorCO opr = new OperatorCO(new OperatorView(),new OperatorData());
		// short
		String pass = "1aB.";
		
		// one rule
		String pass1 = "ABCDEF";
		String pass2 = "abcdef";
		String pass3 = "abcdef";
		
		// two rules
		String pass4 = "abcdeF";
		String pass5 = "abcde1";
		String pass6 = "ABCDE1";
		String pass7 = "123456";
		
		// illegal characters
		String pass8 = "123Morten$";
		
		// three rules
		String pass9 = "Abcde1";
		
		assertTrue(!opr.validatePassword(pass));
		assertTrue(!opr.validatePassword(pass1));
 		assertTrue(!opr.validatePassword(pass2));
		assertTrue(!opr.validatePassword(pass3));
		assertTrue(!opr.validatePassword(pass4));
		assertTrue(!opr.validatePassword(pass5));
		assertTrue(!opr.validatePassword(pass6));
		assertTrue(!opr.validatePassword(pass7));
		assertTrue(!opr.validatePassword(pass8));

		
		assertTrue(opr.validatePassword(pass9));
	}

}
