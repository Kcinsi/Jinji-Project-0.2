package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JinjiDao;

@WebServlet("/ServletKanriShinkiGakuseiUpdate")
public class ServletKanriShinkiGakuseiUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			String ID = request.getParameter("ID");
			String Name = request.getParameter("Name");
			String update_sql = "INSERT INTO komono (ID, Name) VALUES ('" + ID + "', '" + Name + "');";
			Boolean updateOK = JinjiDao.updateGakusei(update_sql);
			if(updateOK) {
				RequestDispatcher dispather = request.getRequestDispatcher("ServletKanriShinkiGakusei");
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