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
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage=10;
		if(request.getParameter("rowPerPage")!=null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		FilmService filmService = new FilmService();
		List<FilmList> filmList = filmService.getFilmInventoryList(currentPage, rowPerPage);
		
		int totalCount = filmService.getFilmInventoryCount();
		int lastPage= (totalCount/rowPerPage)+1;
		int showPage=10; 
		int firstShow= currentPage-((currentPage)%showPage)+1;
		if((currentPage%showPage)==0) {
			firstShow= currentPage-((currentPage-1)%showPage);
			
		}
		int lastShow = firstShow+showPage-1;
		System.out.println("lastPage : "+lastPage);
		System.out.println("currentPage : "+currentPage);
	
		System.out.println("firstShow : "+firstShow);
		System.out.println("lastShow : "+lastShow);
		request.setAttribute("firstShow", firstShow);
		request.setAttribute("lastShow", lastShow);
	
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		
		request.setAttribute("filmList", filmList);
		request.getRequestDispatcher("/WEB-INF/views/auth/filmInventory.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
