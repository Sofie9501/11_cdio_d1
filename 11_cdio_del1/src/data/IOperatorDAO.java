package data;

import java.util.List;

import utils.DALException;

public interface IOperatorDAO {
	OperatorDTO getOperatoer(int oprId) throws DALException;
	List<OperatorDTO> getOperatoerList() throws DALException;
	void createOperatoer(OperatorDTO opr) throws DALException;
	void updateOperatoer(OperatorDTO opr) throws DALException;
	void deleteOperatoer(OperatorDTO opr) throws DALException;

}
