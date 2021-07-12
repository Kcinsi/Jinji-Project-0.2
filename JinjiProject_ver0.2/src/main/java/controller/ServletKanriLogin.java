package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletKanriLogin")
public class ServletKanriLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String kanri_id = null;
		String kanri_pass = null;
		kanri_id = request.getParameter("kanri_id");
		kanri_pass = request.getParameter("kanri_pass");
		try {
			if(kanri_pass==null) {
				kanri_id = (String) session.getAttribute("kanri_id");
				kanri_pass = (String) session.getAttribute("kanri_pass");
			}
			if(kanri_id.equals("KANRI") && kanri_pass.equals("0000")) {
				session.setAttribute("kanri_id", kanri_id);
				session.setAttribute("kanri_pass", kanri_pass);
				RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/jsp/kanri.jsp");
				dispather.forward(request, response);
			}
			else {
				RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/jsp/kanrierror.jsp");
				dispather.forward(request, response);
			}
		}
		catch (Exception e) {
			RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/jsp/kanrierror.jsp");
			dispather.forward(request, response);
		}
	}
}