package model;

import DAO.AccountDAO;

public class RegAccountLogic {
	
	public ErrorObj CreateAnAccount(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean isCreate = dao.insertAccount(account);
		String msg = "";
		if(isCreate) {
			msg = "登録されました";
		}else {
			msg = "登録エラーです。入力された内容を確認しもう一度登録しなおしてください。";
		}
		return new ErrorObj(isCreate,msg);
	}
	
}
