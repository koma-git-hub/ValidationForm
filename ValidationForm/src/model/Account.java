package model;

public class Account {
	private String name;
	private String id;
	private String pass;
	
	public Account(String id,String name,String pass) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.name = name;
		this.id = id;
		this.pass = pass;
	}
	
	public Account(String id,String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}
	
}
