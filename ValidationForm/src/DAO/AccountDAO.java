package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Account;
import model.ErrorObj;
import model.LoginModel;

public class AccountDAO implements SqlSetting {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	ErrorObj error;
	
	public AccountDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
		con = null;
		pstmt = null;
		rs = null;
		error = new ErrorObj();
	}
	
	public Account findByLogin(LoginModel login) {
		Account account =null;
		
		try {
			
			con = getConnection();
			
			String sql = "select * from account where id = ? and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPass());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				
				account = new Account(id, name, pass);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			closeWork(con, pstmt, rs);
			
		}
		
		return account;
		
	}

	
	public ErrorObj isDuplication(String value,String columnsName){
		
		try {
			
			con = getConnection();
			String baseStr = "select * from account ";
			String conditionStr = "where " + columnsName + " = ?";
			String sql = 
				baseStr + conditionStr;
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, value);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()!=false) {
				error.setError(true);
				error.setMsg("すでに使用されています。");
			}
			
		}catch(Exception e) {
			
			error.setError(true);
			error.setMsg("データベース操作エラー");
			
		}finally {
			
			closeWork(con, pstmt);
			
		}
		
		return error;
		
	}
	
	public boolean insertAccount(Account account) {
		
		try {
			
			con = getConnection();
			System.out.println("id: " + account.getId());
			System.out.println("name: " + account.getName());
			System.out.println("pass: " + account.getPass());
			String sql = 
				"INSERT INTO `account`(`id`, `name`, `pass`) VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,account.getId());
			pstmt.setString(2,account.getName());
			pstmt.setString(3,account.getPass());
			
			int result = pstmt.executeUpdate();
			
			return (result==1);
			
		}catch(Exception e) {
			
			System.out.println("insertError");
			System.out.println(e);
			
			return false;
			
		}finally {
			
			closeWork(con, pstmt);
			
		}
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		System.out.println("conection");
		
		return DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
		
	}
	
	public java.sql.Date getDateFormat(String date) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat(SDF_FORMAT);
		java.util.Date utilDate = sf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(utilDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return new java.sql.Date(cal.getTimeInMillis());
		
	}
	
	private void closeWork(Connection con,PreparedStatement pstmt) {
		
		try {
			
			if (pstmt != null) {
				pstmt.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (con != null) {
					con.close();
				}
					
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
	}
	private void closeWork(Connection con,PreparedStatement pstmt,ResultSet rs) {
		
		try {
			
			if (rs != null) {
				rs.close();
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (pstmt != null) {
					pstmt.close();
				}
					
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			} finally {
				
				try {
					
					if (con != null) {
						con.close();
					}
						
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
			}
		}
	}
}
