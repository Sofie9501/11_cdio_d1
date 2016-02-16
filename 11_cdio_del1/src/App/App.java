package App;

import controllers.OperatorCO;
import data.OperatorData;
import view.OperatorView;

public class App {
	public static void main(String[] args){
		new OperatorCO(new OperatorView(), new OperatorData()).run(); 
	}
}
