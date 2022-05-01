package model;

public class ErrorObj {
	private boolean isError;
	private String msg;
	public ErrorObj() {
		// TODO 自動生成されたコンストラクター・スタブ
		this.isError = false;
		this.msg = "";
	}
	public ErrorObj(boolean isError,String msg) {
		this.isError = isError;
		this.msg = msg;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
