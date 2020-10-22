package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.vo.Stats;
//실행순서listener->filter-> servlet->service->dao
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	//로그인한 사람 구하기
	private StatsService statsService;
	private StaffService staffService;
	//로그인폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff")!=null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		
		Map<String,Object> map = statsService.getStats(); //현재 날짜의 count수를 찾아 stats에 넣는다.
		
		//map 풀기
		Stats stats=(Stats)map.get("returnStats");  // map에 있는 returnStats를  강제 형변환해서 stats메서드의 cnt에 넣는다.
		System.out.println(stats.getCnt()+"<----selvlet(map stats 현재 방문자수)");
		long totalCount = (long)map.get("totalCount");
		System.out.println(totalCount+"<----selvlet(map totalcount  총방문자수)");
		request.setAttribute("stats",stats);
		request.setAttribute("totalCount", totalCount);
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	//로그인액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		System.out.println("servlet doPost시작");
		
		staffService = new StaffService();
		HttpSession session = request.getSession();
		Staff staff= new Staff();
		//로그인 페이지의 값 받아오기
		String staffEmail = request.getParameter("id");
		String staffPW = request.getParameter("pw");
		System.out.println(staffEmail+"<----입력한 이메일 확인");
		
		//staff 객체에 값 넣기
		staff.setEmail(staffEmail);
		staff.setPassword(staffPW);
		
		//service에 이메일 있는지 확인
		Staff returnStaff= staffService.getStaffByKey(staff);
		System.out.println(returnStaff+"<----retrunStaff의 값 확인");
		
		//있으면 로그인성공
		if(returnStaff != null) {
			System.out.println("로그인성공");
			// session에 담기
			session.setAttribute("loginStaff", staffEmail);
			//포워딩
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			
			return;
		}
			//실패
		System.out.println("로그인실패");
		//다시 로그인 페이지 이동
		response.sendRedirect(request.getContextPath()+"/LoginServlet");
	}
}


