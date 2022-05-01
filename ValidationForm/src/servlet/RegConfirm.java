package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.RegAccountLogic;

/**
 * Servlet implementation class RegConfirm
 */
@WebServlet("/regConfirm")
public class RegConfirm extends HttpServlet implements settingString.URL {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegConfirm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Account newAccount = request.getSession().getAttribute("resultAccount") instanceof Account?
				(Account)request.getSession().getAttribute("resultAccount") : null;
		RegAccountLogic regLogic = new RegAccountLogic();
		regLogic.CreateAnAccount(newAccount);
		request.setAttribute("account", newAccount);
		RequestDispatcher ds = request.getRequestDispatcher(LOGIN_RESULT_JSP);
		ds.forward(request, response);
	}

}
