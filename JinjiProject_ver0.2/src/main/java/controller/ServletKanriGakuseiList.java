package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Gakusei;
import dao.JinjiDao;

@WebServlet("/ServletKanriGakuseiList")
public class ServletKanriGakuseiList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		try {
			String kensaku_sql = "SELECT * FROM komono;";
			List<Gakusei> gakusei_list = JinjiDao.getGakusei(kensaku_sql);
			
			session.setAttribute("gakusei_list", gakusei_list);
			RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/jsp/kanriichiran.jsp");
			dispather.forward(request, response);
		}
		catch (Exception e) {
			RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/jsp/kanrierror.jsp");
			dispather.forward(request, response);
		}
	}
}