package model;

public class Login {
	
	private String id;
	private String pass;
	public Login(String id, String pass) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id=id;
		this.pass=pass;
	}
	
	public String getPass() {
		return pass;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return "id: " + this.id + " pass: " + pass;
	}
}
