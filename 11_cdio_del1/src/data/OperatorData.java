package data;

import java.util.ArrayList;
import java.util.List;


import utils.DALException;

public class OperatorData implements IOperatorDAO{

	List<OperatorDTO> operators;

	public OperatorData(){
		operators =  new ArrayList<>();
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
		if(operators.size() == 0)
			throw new DALException("No operators stored");
		
		List<OperatorDTO> clonedList = new ArrayList<>();
		for(OperatorDTO opr: operators)
			clonedList.add(new OperatorDTO(opr));
		
		return clonedList;
	}

	@Override
	public void createOperator(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		for (int i = 0; i < operators.size(); i++) {
			if (operators.get(i).getOprId()==opr.getOprId()){
				operators.get(i).setCpr(opr.getCpr());
				operators.get(i).setOprName(opr.getOprName());
				return;
			}
		}
		throw new DALException(opr.getOprId() + " can't be updated, cause OprID does not exist");
	}

	@Override
	public void deleteOperator(OperatorDTO opr) throws DALException {
		for (int i = 0; i < operators.size(); i++) {
			if (operators.get(i).getOprId()==opr.getOprId()){
				operators.remove(i);
				return;
			}
		}
		throw new DALException(opr.getOprId() + " can't be deleted, cause OprID does not exist");
	}
}
