package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.CustomerService;
import sakila.vo.Address;
import sakila.vo.Customer;
import sakila.vo.CustomerAndAddress;


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
		List<CustomerAndAddress> list = customerService.getselectCustomerList(currentPage, rowPerPage);
		CustomerAndAddress ca = new CustomerAndAddress();
		//service에서 실행한 메서드를 가져와 list안에 넣는다
		
		
		System.out.println("CustomerServlet 2번째 접속 성공");
		System.out.println("CustomerServlet에서 배열 list size 보기:"+list.size());
		
		request.setAttribute("list", list);
	
		request.getRequestDispatcher("/WEB-INF/views/auth/customerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
