package sakila.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.FilmService;
import sakila.vo.FilmList;


@WebServlet("/auth/FilmInventoryServlet")
public class FilmInventoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FilmInvetoryServlet 접속 성공");
		int currentPage =1;
		if(request.getAttribute("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage=10;
		if(request.getAttribute("rowPerPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		FilmService filmService = new FilmService();
		List<FilmList> filmList = filmService.getFilmInventoryList(currentPage, rowPerPage);
		
		request.setAttribute("filmList", filmList);
		request.getRequestDispatcher("/WEB-INF/views/auth/filmInventory.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
