package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.LoginLogic;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet implements settingString.URL {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher ds = request.getRequestDispatcher(LOGIN_JSP);
		ds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass1");
		
		LoginLogic loginLogic = new LoginLogic();
		HttpSession session = request.getSession();
		Account account = new Account(id,pass);
		RequestDispatcher ds;
		boolean isLogin = loginLogic.executeDB(new model.LoginModel(id, pass));
		
		if(isLogin) {
			account = loginLogic.getAccountDB();
			session.setAttribute("account", account);
			request.setAttribute("isLogin", "");
			ds = request.getRequestDispatcher(LOGIN_RESULT_JSP);
		}else {
			request.setAttribute("isLogin", "ログインできませんでした<br>IDとパスワードをお確かめの上、入力しなおしてください");
			ds = request.getRequestDispatcher(LOGIN_JSP);
		}
		
		ds.forward(request, response);
	}

}
