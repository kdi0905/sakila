package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.Query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	//오늘 접속 했는지 안했는지 확인 //없으면 =false  있으면= true
	public Stats selectDay(Connection conn,Stats stats) throws Exception {
		
		System.out.println(stats.getDay());
		System.out.println(stats.getCnt());
		Stats returnStats=null;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);
		//SELECT day,cnt  FROM stats WHERE day=? 
		stmt.setString(1,stats.getDay());
		ResultSet rs= stmt.executeQuery();
		System.out.println(stmt+"<----dao(selectDay)");
		System.out.println(stats.getDay()+"<----dao(getDay )있는지 확인");
		System.out.println(returnStats+"<---dao(returnStats)");
		
		if(rs.next()) {
			returnStats = new Stats();
			System.out.println("Stats 객체 생성");
			returnStats.setDay(rs.getString("day"));
			System.out.println(returnStats.getDay() + "<---dao(select Day)");
			returnStats.setCnt(rs.getLong("cnt"));
			System.out.println(returnStats.getCnt()+"<---dao(select Count)");
		}
		
		return returnStats;
		
	}
	//총 방문자 수 구하기
	 public long totalCount(Connection conn)throws Exception{
		 long totalCount =0;
		PreparedStatement stmt= conn.prepareStatement(StatsQuery.TOTAL_COUNT);
		//SELECT sum(cnt) FROM stats
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			totalCount = rs.getLong("sum(cnt)");
		}
		System.out.println(totalCount+"<---dao(selsct totalCount)");
		 return totalCount;
	 }
	//오늘 접속한 사람 cnt추가 //오늘 접속  x= false
	public void insertStats(Connection conn, Stats stats)throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STAT);
		//INSERT INTO stats(day,cnt)VALUES(?,1)
		stmt.setString(1, stats.getDay());
		System.out.println(stats.getDay() + "<---dao(insert Day)");
		stmt.executeUpdate();
	}
	
	//오늘 다시 접속한 사람 cnt 업데이트  // 오늘접속  o = true 
	public void updateStats(Connection conn,Stats stats)throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		//UPDATE stats SET cnt=cnt+1 WHERE day=?
		stmt.setString(1,stats.getDay());
		System.out.println(stats.getDay() + "<---dao(update Day)");
		System.out.println(stats.getCnt()+ "<----dao(update cnt)");
		stmt.executeQuery();
	}
}
