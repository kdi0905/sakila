package sakila.Query;

public class StaffQuery {
	//로그인 확인
	public final static String SELECT_STAFF_BY_KEY 
	="SELECT staff_id, username FROM staff WHERE staff_id=? AND password=PASSWORD(?)";
}
