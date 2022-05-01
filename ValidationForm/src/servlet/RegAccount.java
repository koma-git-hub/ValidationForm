package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.MosaicLogic;


/**
 * Servlet implementation class regAccount
 */
@WebServlet("/regAccount")
public class RegAccount extends HttpServlet implements settingString.URL {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegAccount() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher ds = request.getRequestDispatcher(REG_ACCOUNT_JSP);
		ds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass1");
		Account resultAccount = new Account(id,name,pass);
		
		Account viewAccount = new Account(id,name,MosaicLogic.mosaicPassword(pass));
		request.getSession().setAttribute("resultAccount", resultAccount);
		request.setAttribute("account", viewAccount);
		RequestDispatcher ds = request.getRequestDispatcher(REG_CONFIRM_JSP);
		ds.forward(request, response);
	}

}
