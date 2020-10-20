package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.Query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	//오늘 접속 했는지 안했는지 확인 //없으면 =false  있으면= true

	public Stats selectDay(Connection conn,Stats stats)throws Exception {
		Stats returnStats=null;
		PreparedStatement stmt =conn.prepareStatement(StatsQuery.SELECT_DAY);
		//SELECT day,count  FROM stats WHERE day=? 
		stmt.setString(1,stats.getDay());
		ResultSet rs= stmt.executeQuery();
		if(rs.next()) {
			System.out.println(stats.getDay() + "<---select Day");
			System.out.println(stats.getCount()+"<---select Count");
			returnStats=new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCount(rs.getLong("count"));
		}
		return returnStats;
	}
	//오늘 접속한 사람 count추가 //오늘 접속  x= false
	public void insertStats(Connection conn, Stats stats)throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STAT);
		//INSERT INTO stats(day,count)VALUES(?,1)
		stmt.setString(1, stats.getDay());
		System.out.println(stats.getDay() + "<---insert Day");
		stmt.executeUpdate();
	}
	
	//오늘 다시 접속한 사람 count 업데이트  // 오늘접속  o = true 
	public void updateStats(Connection conn,Stats stats)throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		//UPDATE stats SET count=count+1 WHERE day=?
		stmt.setString(1,stats.getDay());
		System.out.println(stats.getDay());
		System.out.println(stats.getDay() + "<---update Day");
		stmt.executeQuery();
	}
}
