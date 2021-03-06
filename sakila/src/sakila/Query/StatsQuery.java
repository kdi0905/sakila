package sakila.Query;

public class StatsQuery {
	public static final String SELECT_DAY="SELECT day, cnt FROM stats WHERE day=? "; //day가 있는지 확인
	public static final String INSERT_STAT="INSERT INTO stats(day,cnt) VALUES(?,1)";//추가
	public static final String UPDATE_STATS="UPDATE stats SET cnt=cnt+1 WHERE day=?";//업데이트
	public static final String TOTAL_COUNT="SELECT sum(cnt) FROM stats";//총 방문자수
}
