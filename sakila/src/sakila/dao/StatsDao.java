package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import sakila.Query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	StatsQuery statsQuery =new StatsQuery();
	Stats stats = new Stats();
	//오늘 접속 했는지 안했는지 확인 //없으면 =false  있으면= true
	public boolean selectDay(Connection conn,Stats stats)throws Exception {
		boolean result=false;
		PreparedStatement stmt =conn.prepareStatement(statsQuery.SELECT_DAY);
		stmt.setString(1, );
		if(rs.next) {
			return true; //업데이트(update)실행
		}
		return false; // 추가(insert) 실행
	}
	//오늘 접속한 사람 count추가 //오늘 접속  x= false
	public void insertStats(Connection conn, Stats stats)throws Exception {
		
	}
	
	//오늘 다시 접속한 사람 count 업데이트  // 오늘접속  o = true 
	public void updateStats(Connection conn)throws Exception {
		
	}
}
