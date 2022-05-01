package model;

import DAO.AccountDAO;

public class ValidationLogic {
	
	public ErrorObj nameCheck(String name, String columnsName) {
		
		AccountDAO dao = new AccountDAO();
		ErrorObj error = dao.isDuplication(name,columnsName);
		return error;
		
	}
}
