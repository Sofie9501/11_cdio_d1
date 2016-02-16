package utils;

public class DALException extends Exception{

	private static final long serialVersionUID = 4734296969844717751L;

	public DALException(String error){
		super(error);
	}
}
