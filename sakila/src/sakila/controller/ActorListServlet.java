package sakila.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.ActorService;
import sakila.vo.Actor;


@WebServlet("/auth/ActorListServlet")
public class ActorListServlet extends HttpServlet {
	private ActorService actorService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ActorListServlet 접속 성공");
		List<Actor> list = actorService.getSelectActorList();
		System.out.println("ActorServlet list사이즈: "+list.size());
		request.setAttribute("actorList", list);
		request.getRequestDispatcher("/WEB-INF/views/auth/actorList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
