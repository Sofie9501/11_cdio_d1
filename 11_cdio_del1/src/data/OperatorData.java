package data;

import java.util.ArrayList;
import java.util.List;


import utils.DALException;

public class OperatorData implements IOperatorDAO{

	List<OperatorDTO> operators;

	public OperatorData(){
		operators =  new ArrayList<>();
		
		// Tilføjer admin med prækonfigurerede værdier
		OperatorDTO admin = new OperatorDTO();
		admin.setOprId(10);
		admin.setCpr("123456-7890");
		admin.setPassword("Abc02324");
		admin.setAdmin(true);
		admin.setOprName("Administrator");
		
		operators.add(admin);
	}

	// Returns an operator object if opr id exist otherwise throws exception
	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		for(OperatorDTO opr: operators){
			if(opr.getOprId() == oprId)
				return opr;
		}
		throw new DALException("Operator with " + oprId + " does not exist");
	}


	// returns a list with a copy of all operatorDTO objects in operators list
	@Override
	public List<OperatorDTO> getOperatorList() throws DALException {
		// Throw exception if no operators
		if(operators.size() == 0)
			throw new DALException("No operators stored");

		List<OperatorDTO> clonedList = new ArrayList<>();
		for(OperatorDTO opr: operators)
			clonedList.add(new OperatorDTO(opr));

		return clonedList;
	}

	@Override
	public void createOperator(OperatorDTO opr) throws DALException {
		for(OperatorDTO oprerator: operators){
			if (oprerator.getOprId()==opr.getOprId()){
				throw new DALException("OperatorId " + opr.getOprId() + " already exist.");
			}
			else if (oprerator.getCpr()==opr.getCpr()){
				throw new DALException("Cpr " + opr.getCpr() + " already exist.");
			}
		}
		operators.add(opr);
	}

	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		for(OperatorDTO oprerator: operators) {
			if (oprerator.getOprId()==opr.getOprId()){
				oprerator.setCpr(opr.getCpr());
				oprerator.setOprName(opr.getOprName());
				return;
			}
		}
		throw new DALException(opr.getOprId() + " can't be updated, cause OprID does not exist");
	}

	@Override
	public void deleteOperator(OperatorDTO opr) throws DALException {
		if(!operators.remove(this.getOperator(opr.getOprId())))
			throw new DALException(opr.getOprId() + " can't be deleted, cause OprID does not exist");
	}
}
