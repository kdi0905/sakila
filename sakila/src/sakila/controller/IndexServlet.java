package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/auth/IndexServlet")
public class IndexServlet extends HttpServlet {
	
	//로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IndexServlet 접속 성공");
		request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
		
	}

}
