package DAO;

public interface SqlSetting {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String URL =
			"jdbc:mysql://ec2rdsdatabase.c0heqotratpa.ap-northeast-1.rds.amazonaws.com:3306/";
	final String USER_NAME = "ec2rdsAdmin";
	final String PASSWORD = "nakadashide19";
	final String DB_NAME = "chatroom_db";
	final String TABLE_NAME = "account";
	final String[] COLUMNS_NAMES = {"id","name","pass","no"};
	final String[] COLUMNS_NAME_AS = {"ID","名前","パスワード",""};
	final String SDF_FORMAT = "yyyy/MM/dd";
}
