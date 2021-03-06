package sakila.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.CustomerService;
import sakila.vo.CustomerList;


@WebServlet("/auth/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
		private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CustomerServlet 접속 성공");
		//페이징 작업
		int currentPage =1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage=10;
		if(request.getParameter("rowPerPage")!=null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		customerService = new CustomerService();
		List<CustomerList> list = customerService.getselectCustomerList(currentPage, rowPerPage);
		
		//service에서 실행한 메서드를 가져와 list안에 넣는다
		// 페이징 
		//총 개수 구하기
		int totalCount = customerService.getCustomerListCount();
		int lastPage= (totalCount/rowPerPage)+1;
		int showPage=10; 
		int firstShow= currentPage-((currentPage)%showPage)+1;
		if((currentPage%showPage)==0) {
			firstShow= currentPage-((currentPage-1)%showPage);
			
		}
		
		int lastShow = firstShow+showPage-1;
		System.out.println("lastPage : "+lastPage);
		System.out.println("currentPage : "+currentPage);
		System.out.println("CustomerServlet 2번째 접속 성공");
		System.out.println("CustomerServlet에서 배열 list size 보기:"+list.size());
		System.out.println("firstShow : "+firstShow);
		System.out.println("lastShow : "+lastShow);
		request.setAttribute("firstShow", firstShow);
		request.setAttribute("lastShow", lastShow);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/auth/customerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
