package sakila.dao;

import java.sql.*;
import sakila.Query.StaffQuery;
import sakila.vo.Staff;
import sakila.vo.StaffAndAddressAndCityAndCountry;

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
			System.out.println(returnStaff.getStaffId()+" <----DAO(staffId)");
			returnStaff.setEmail(rs.getString("email"));
			System.out.println(returnStaff.getEmail()+" <----DAO(email)");
			returnStaff.setUsername(rs.getString("username"));
			System.out.println(returnStaff.getUsername()+" <----DAO(username)");
		}
		
		
		return returnStaff;
	}
	//관리자 정보 보기
	public StaffAndAddressAndCityAndCountry selectStaffOneListById(Connection conn,Staff staff)throws Exception {
		System.out.println();
		System.out.println("StaffDao : selectStaffByKey시작");
		StaffAndAddressAndCityAndCountry sacc = null;
		System.out.println("StaffDao: "+staff.getStaffId() +" --->staffid확인");
		PreparedStatement stmt= conn.prepareStatement(StaffQuery.SELECT_STAFFONE_LIST_BY_ID);
		System.out.println(stmt);
		stmt.setInt(1, staff.getStaffId());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			sacc = new StaffAndAddressAndCityAndCountry();
			sacc.staff.setUsername(rs.getString("s.username"));
			System.out.println("StaffDao의 staff username : "+sacc.staff.getUsername());
			sacc.staff.setAddressId(rs.getInt("s.address_id"));
			System.out.println("StaffDao의 staff address_id : "+sacc.staff.getAddressId());
			sacc.staff.setEmail(rs.getString("s.email"));
			System.out.println("StaffDao의 staff email : "+sacc.staff.getEmail());
			sacc.staff.setPicture(rs.getString("s.picture"));
			System.out.println("StaffDao의 staff picture : "+sacc.staff.getPicture());
			
			sacc.address.setAddress(rs.getString("si.address"));
			System.out.println("StaffDao의 address Address : "+sacc.address.getAddress());
			sacc.address.setPhone(rs.getString("si.phone"));
			System.out.println("StaffDao의 address phone : "+sacc.address.getPhone());
			
			sacc.city.setCity(rs.getString("si.city"));
			System.out.println("StaffDao의 city city : "+sacc.city.getCity());
			
			sacc.coutry.setCountry(rs.getString("si.country"));
			System.out.println("StaffDao의 coutry country : "+sacc.coutry.getCountry());
		}
		return sacc;
	}
}
