package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StatsService;
import sakila.vo.Stats;
//실행순서listener->filter-> servlet->service->dao
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	//로그인한 사람 구하기
	private StatsService statsService;
	//로그인폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff")!=null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		Stats stats = statsService.getStats(); //현재 날짜의 count수를 찾아 stats에 넣는다.
		request.setAttribute("stats", stats);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	//로그인액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}


