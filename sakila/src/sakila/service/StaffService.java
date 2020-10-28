package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.dao.StaffDao;
import sakila.dbUtil.DBUtil;
import sakila.vo.*;

public class StaffService {
	private StaffDao staffDao;
	
	//staff 의 로그인 확인작업
	public Staff getStaffByKey(Staff staff) {
		
		System.out.println("StaffService시작");
		
		Staff returnStaff=null;
		Connection conn =null;
		try {
			staffDao = new StaffDao();
			//db접속
			DBUtil dbUtil = new DBUtil();
			conn=dbUtil.selectDB();
			conn.setAutoCommit(false);
			
			System.out.println(conn+"db동작확인");
			System.out.println(staff);
			
			//dao에서 이메일 확인 작업 실행
			returnStaff =staffDao.selectStaffByKey(conn, staff);
			
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
		System.out.println("StaffService종료");
		return returnStaff;
	}
	
	//관리자 정보 찾기
	public StaffAndAddressAndCityAndCountry getStaffOneListById(Staff staff) {
		System.out.println("StaffService의 관리자 정보 찾기 실행");
		StaffAndAddressAndCityAndCountry returnsacc=null;
		Connection conn=null;
		try {
			staffDao = new StaffDao();
			DBUtil dbUtil =new DBUtil();
			conn=dbUtil.selectDB();
			conn.setAutoCommit(false);
			
			returnsacc= staffDao.selectStaffOneListById(conn, staff);
			System.out.println(returnsacc);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("StaffService 종료!!");
		return returnsacc;
	}
}
