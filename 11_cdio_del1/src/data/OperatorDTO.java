package data;

/**
 *	OperatorDTO is the domain model for
 *	operators in the system
 */
public class OperatorDTO{
	private int oprId;
	private String oprName;
	private String cpr;			// CPR should be on the from xxxxxx-xxxx
	private String password;
	boolean admin = false;
	
	public OperatorDTO(){
		
	}
	
	// Copy Constructor
	public OperatorDTO(OperatorDTO opr){
		this.oprId = opr.oprId;
		this.oprName = opr.oprName;
		this.cpr = opr.cpr;
		this.password = opr.password;
	}
	
	
	public int getOprId() {
		return oprId;
	}
	public void setOprId(int oprId) {
		this.oprId = oprId;
	}
	public String getOprName() {
		return oprName;
	}
	public void setOprName(String oprName) {
		this.oprName = oprName;
	}
	public String getCpr() {
		return cpr;
	}
	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
