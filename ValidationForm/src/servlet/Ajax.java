package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ErrorObj;
import model.ValidationLogic;

/**
 * Servlet implementation class Ajax
 */
@WebServlet("/ajax")
public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String inputValue = request.getParameter("inputValue");
		String columnsName = request.getParameter("columnsName");		
				
		ValidationLogic valLogic = new ValidationLogic();
		ErrorObj error = valLogic.nameCheck(inputValue,columnsName);
		PrintWriter out = response.getWriter();
		out.print(error.getMsg());
		
	}

}
