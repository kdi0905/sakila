package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.Query.CustomerQuery;
import sakila.vo.Address;
import sakila.vo.Customer;
import sakila.vo.CustomerAndAddress;
	
public class CustomerDao {
	public List<CustomerAndAddress> selectCustomerList(Connection conn,final int BEGIN_ROW,final int ROW_PER_PAGE)throws Exception {
		System.out.println("CustomerDao 접속성공 고객리스트 확인");
		List<CustomerAndAddress> list = new ArrayList<CustomerAndAddress>(); 
		PreparedStatement stmt = conn.prepareStatement(CustomerQuery.SELECT_CUSTOMER_LIST);
		stmt.setInt(1,BEGIN_ROW);
		stmt.setInt(2, ROW_PER_PAGE);
		System.out.println("CustomerDao : stmt 확인"+stmt);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			CustomerAndAddress ca= new CustomerAndAddress();
			ca.customer = new Customer();
			ca.address = new Address();
			ca.customer.setCustomerId(rs.getInt("c.customer_id"));
			ca.customer.setFirstName(rs.getString("c.first_name"));
			ca.customer.setFirstName(rs.getString("c.last_name"));
			ca.customer.setActive(rs.getInt("c.active"));
			ca.address.setAddress(rs.getString("a.address"));
			list.add(ca);
		}
		rs.close();
		stmt.close();
		System.out.println("CustomerDao종료!!!");
		return list;
	}
}