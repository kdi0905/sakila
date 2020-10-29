package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.commons.DBUtil;
import sakila.dao.CustomerDao;
import sakila.vo.CustomerAndAddress;

public class CustomerService {
	private CustomerDao customerDao;
	public List<CustomerAndAddress> getselectCustomerList(int currentPage,int rowPerPage){
		System.out.println("CustomerService 시작!!");
		List<CustomerAndAddress> list =null;
		Connection conn =null;
	
		try {
			customerDao= new CustomerDao();
			DBUtil dbUtil = new DBUtil();
			conn= dbUtil.selectDB();
			conn.setAutoCommit(false);
			int biginRow = (currentPage-1)*rowPerPage;
			list = new ArrayList<CustomerAndAddress>();
			list = customerDao.selectCustomerList(conn,biginRow , rowPerPage);
			
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
