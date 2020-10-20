package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.vo.Stats;


public class StatsService {
	private StatsDao statsDao;
	public void countStats() {
		statsDao = new StatsDao();
		final String URL="jdbc:mariadb://localhost:3306/stats";
		final String USER ="root";
		final String PASSWORD="java1004";
		Connection conn=null;
		try {
			conn= DriverManager.getConnection(URL,USER,PASSWORD);
			conn.setAutoCommit(false);
			
			//오늘 날짜 구해서 있는지 확인한다음 수정할건지 추가할건지 확인
			Calendar today = Calendar.getInstance(); //날짜 구하기
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd"); //형식 초기화
			String day= formater.format(today); //day변수에 날짜 넣기
			Stats stats = new Stats();
			stats.setDay(day);
			
			if(statsDao.selectDay(conn, stats)) { //현재 날짜 있는지 확인
				statsDao.updateStats(conn); // 현재 날짜가 있으면 업데이트실행
			} else {
				statsDao.insertStats(conn, stats); // 현재 날짜가 없으면 추가 실행
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
