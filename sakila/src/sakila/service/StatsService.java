package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sakila.dao.StatsDao;
import sakila.vo.Stats;


public class StatsService {
	private StatsDao statsDao;
	//현재 날짜 구하기
	private Stats getToday() {
		Calendar today = Calendar.getInstance(); //날짜 구하기
		SimpleDateFormat formater = new SimpleDateFormat("YYYY-MM-DD"); //형식 초기화
		String day= formater.format(today.getTime()); //day변수에 날짜 넣기
		Stats stats = new Stats();
		stats.setDay(day);
		return stats; //현재 날짜 리턴
	}
	
	//현재 날짜 방문자수, 총 방문자수 구해서 Map사용해서 리턴하기
	public Map<String, Object> getStats() { //날짜가 있는지 확인해서 Stats의 값을 리턴시켜준다. //public Map<String,Object>getStats()
		Map<String,Object> map = new HashMap<String, Object>(); // 동시 리턴하는 map 생성
		Stats returnStats =null;
		statsDao = new StatsDao();
		final String URL="jdbc:mariadb://localhost:3306/sakila";
		final String USER ="root";
		final String PASSWORD="java1004";
		long totalCount;
		Connection conn=null;
		try {
			conn= DriverManager.getConnection(URL,USER,PASSWORD);
			conn.setAutoCommit(false);
			Stats stats= this.getToday(); //현재 시간을 stats에 넣는다.
			 returnStats = statsDao.selectDay(conn, stats); //현재 날짜가 있는지 찾는다.
			 System.out.println(returnStats.getCnt()+"<---Service(returnStats.getCnt()출력)");
			 totalCount= statsDao.totalCount(conn); // 총 방문자수 구하기
			 System.out.println(totalCount+"<---Service(totalCount 총 방문자수 출력)");
			 //map
			 map.put("totalCount", totalCount); //map에 추가하기
			 map.put("returnStats", returnStats);//map에 추가하기
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
				
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
		
	}
	public void countStats() {
		statsDao = new StatsDao();
		final String URL="jdbc:mariadb://localhost:3306/sakila";
		final String USER ="root";
		final String PASSWORD="java1004";
		Connection conn=null;
		try {
			conn= DriverManager.getConnection(URL,USER,PASSWORD);
			conn.setAutoCommit(false);
			
			//오늘 날짜 구해서 있는지 확인한다음 수정할건지 추가할건지 확인
			Stats stats= this.getToday();
			
			if(statsDao.selectDay(conn, stats)==null) { //현재 날짜 있는지 확인
				statsDao.insertStats(conn, stats); // 현재 날짜가 없으면 추가 실행
			} else {
				statsDao.updateStats(conn,stats); // 현재 날짜가 있으면 업데이트실행
			}
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
				
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
