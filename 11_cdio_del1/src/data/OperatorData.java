package data;

import java.util.ArrayList;
import java.util.List;

import utils.DALException;

public class OperatorData implements IOperatorDAO{
	
	List<OperatorDTO> operators;
	
	public OperatorData(){
		operators =  new ArrayList<>();
	}
	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		for(OperatorDTO opr: operators){
			if(opr.getOprId() == oprId)
				return opr;
		}
		throw new DALException("Operator with " + oprId + " does not exist");
	}

	@Override
	public List<OperatorDTO> getOperatorList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOperator(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOperator(OperatorDTO opr) throws DALException {
		if (!operators.remove(opr)){
			throw new DALException(opr.getOprId() + " can't be deleted, cause OprID doesnot exist");
		}
		
	}

}
