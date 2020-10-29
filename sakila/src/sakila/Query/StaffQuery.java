package sakila.Query;

public class StaffQuery {
	//로그인 확인
	public final static String SELECT_STAFF_BY_KEY 
	="SELECT staff_id,email, username FROM staff WHERE email=? AND password=PASSWORD(?)";
	public final static String SELECT_STAFFONE_LIST_BY_ID
	="SELECT s.username,s.address_id,s.email,s.picture,s.first_name,s.last_name,si.address,si.phone,si.city,si.country FROM staff s inner join staff_list si ON s.staff_id=si.ID WHERE s.staff_id=?";
}
