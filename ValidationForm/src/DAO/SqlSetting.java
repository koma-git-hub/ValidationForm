package DAO;

public interface SqlSetting {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String URL =
			"jdbc:mysql://ec2rdsdatab**********mazonaws.com:3306/";
	final String USER_NAME = "ec******";
	final String PASSWORD = "n*******9";
	final String DB_NAME = "******_db";
	final String TABLE_NAME = "account";
	final String[] COLUMNS_NAMES = {"id","name","pass","no"};
	final String[] COLUMNS_NAME_AS = {"ID","名前","パスワード",""};
	final String SDF_FORMAT = "yyyy/MM/dd";
}
