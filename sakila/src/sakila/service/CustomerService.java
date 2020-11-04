package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.commons.DBUtil;
import sakila.dao.CustomerDao;
import sakila.vo.CustomerList;


public class CustomerService {
	private CustomerDao customerDao;
	//고객 리스트 확인
	public List<CustomerList> getselectCustomerList(int currentPage,int rowPerPage){
		System.out.println("CustomerService 시작!!");
		List<CustomerList> list =null;
		
		Connection conn =null;
		try {
			customerDao= new CustomerDao();
			DBUtil dbUtil = new DBUtil();
			conn= dbUtil.selectDB();
			conn.setAutoCommit(false);
			int biginRow = (currentPage-1)*rowPerPage;
			list = new ArrayList<CustomerList>();
			list = customerDao.selectCustomerList(conn,biginRow , rowPerPage);
		
			for(CustomerList cl : list) {			
				System.out.println("고객 리스트확인:"+cl);
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

