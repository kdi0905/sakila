package sakila.dao;

import java.sql.*;
import sakila.Query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	//이메일,비밀번호 있는지 확인
	public Staff selectStaffByKey(Connection conn,Staff staff)throws Exception {
		System.out.println();
		System.out.println("StaffDao(selectStaffByKey시작");
		Staff returnStaff =null;
		/*password(?)*/
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		//SELECT staff_id, username FROM staff WHERE email=? AND password=PASSWORD(?);
		System.out.println(stmt+" <---stmt");
		stmt.setString(1, staff.getEmail());
		System.out.println(staff.getEmail()+" <---dao이메일확인");
		stmt.setString(2, staff.getPassword());
		System.out.println(staff.getPassword()+" <----dao비밀번호확인");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {//값이 있으면 확인
			returnStaff= new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setUsername(rs.getString("username"));
		}
		System.out.println(returnStaff.getStaffId()+" <----DAO(staffId)");
		System.out.println(returnStaff.getUsername()+" <----DAO(username)");
		return returnStaff;
	}


}
