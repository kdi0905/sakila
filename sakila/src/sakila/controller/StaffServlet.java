package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import sakila.service.StaffService;
import sakila.vo.*;


@WebServlet("/auth/StaffServlet")
public class StaffServlet extends HttpServlet {

       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StaffServlet 접속 성공");
		HttpSession session = request.getSession(); //session 값 가져오기
		Staff staff =(Staff)session.getAttribute("loginStaff");
		System.out.println("StaffServlet : "+staff+" sessiont에서 가져온 staff 내용확인");
		StaffService staffservice =new StaffService();
		StaffAndAddressAndCityAndCountry sacc=staffservice.getStaffOneListById(staff);
		System.out.println("StaffServlet 2번째 접속 성공 ");
		System.out.println("StaffServlet sacc  검사 :"+ sacc);
		request.setAttribute("username", sacc.staff.getUsername());
		request.setAttribute("firstName", sacc.staff.getFirstName());
		request.setAttribute("lastName", sacc.staff.getLastName());
		request.setAttribute("email",sacc.staff.getEmail());
		request.setAttribute("picture", sacc.staff.getPicture());
		request.setAttribute("address",sacc.address.getAddress());
		request.setAttribute("phone", sacc.address.getPhone());
		request.setAttribute("city", sacc.city.getCity());
		request.setAttribute("country", sacc.country.getCountry());
		
		request.getRequestDispatcher("/WEB-INF/views/auth/staff.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
