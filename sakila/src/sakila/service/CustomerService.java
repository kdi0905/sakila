package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.commons.DBUtil;
import sakila.dao.CustomerDao;
import sakila.dao.RentalDao;
import sakila.vo.*;


public class CustomerService {
	private CustomerDao customerDao;
	private RentalDao rentalDao;
	//고객 리스트 확인
	public List<CustomerAndAddress> getselectCustomerList(int currentPage,int rowPerPage){
		System.out.println("CustomerService 시작!!");
		List<CustomerAndAddress> list =null;
		
		Connection conn =null;
		String check =null;
		try {
			customerDao= new CustomerDao();
			DBUtil dbUtil = new DBUtil();
			conn= dbUtil.selectDB();
			conn.setAutoCommit(false);
			int biginRow = (currentPage-1)*rowPerPage;
			list = new ArrayList<CustomerAndAddress>();
			list = customerDao.selectCustomerList(conn,biginRow , rowPerPage);
			//고객 연체 체크
			rentalDao = new RentalDao();
			for(CustomerAndAddress s : list) {
				System.out.println("고객 연체 체크할 고객 아이디 : "+s.getCustomerId());
				
				List<Rental> checklist =rentalDao.selectRentalCheck(conn, s.getCustomerId());
			if( checklist != null) {
				check ="Y";
				
			}else {
				check ="N";
				
			}
			s.setCheck(check);
			}
			conn.commit();
		}catch (Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1){
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
		System.out.println("CustomerService 종료!!");
		return list;
	}
}

