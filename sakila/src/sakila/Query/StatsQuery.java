package sakila.Query;

public class StatsQuery {
	public static final String SELECT_DAY="SELECT day,count  FROM stats WHERE day=? "; //day가 있는지 확인
	public static final String INSERT_STAT="INSERT INTO stats(day,count)VALUES(?,1)";//추가
	public static final String UPDATE_STATS="UPDATE stats SET count=count+1 WHERE day=?";//업데이트
}
