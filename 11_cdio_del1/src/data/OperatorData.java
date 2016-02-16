package data;

import java.util.List;

import utils.DALException;

public class OperatorData implements IOperatorDAO{
	
	List<OperatorDTO> operators;
	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		// TODO Auto-generated method stub
		return null;
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
