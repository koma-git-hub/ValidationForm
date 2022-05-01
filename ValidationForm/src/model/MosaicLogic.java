package model;

public class MosaicLogic {

	public static String mosaicPassword(String password) {
		String head = String.valueOf(password.charAt(0));
		String tail = String.valueOf(password.charAt(password.length()-1));
		String mosaic = "";
		for(int i=0; i < password.length()-2; i++) {
			mosaic += "*";
		}
		return head + mosaic + tail;
	}
}
