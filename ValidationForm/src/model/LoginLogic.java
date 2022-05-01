package model;

import DAO.AccountDAO;

public class LoginLogic {
	Account account=null;
	public boolean executeDB(model.Login login) {
		AccountDAO dao = new AccountDAO();
		account = dao.findByLogin(login);
		
		return account!=null;
	}
	public Account getAccountDB() {
			return this.account;
	}
}
