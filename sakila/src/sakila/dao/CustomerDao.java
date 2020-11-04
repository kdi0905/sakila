package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.Query.CustomerQuery;

import sakila.vo.CustomerList;
	
public class CustomerDao {
	//고객 리스트 출력
	public List<CustomerList> selectCustomerList(Connection conn,final int BEGIN_ROW,final int ROW_PER_PAGE)throws Exception {
		System.out.println("CustomerDao 접속성공 고객리스트 확인");
		List<CustomerList> list = new ArrayList<CustomerList>(); 
		PreparedStatement stmt = conn.prepareStatement(CustomerQuery.SELECT_CUSTOMER_LIST);
		//SELECT cl.ID, cl.name, cl.phone, cl.notes, IF((SELECT COUNT(*) FROM rental WHERE return_date IS NULL AND customer_id = cl.ID) > 0,'Y','N') AS overdue 
		//FROM customer_list cl ORDER BY cl.ID ASC LIMIT ?, ?
		stmt.setInt(1,BEGIN_ROW);
		stmt.setInt(2, ROW_PER_PAGE);
		System.out.println("CustomerDao : stmt 확인"+stmt);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			CustomerList cl= new CustomerList();
			cl.setID(rs.getInt("cl.ID"));
			cl.setName(rs.getString("cl.name"));
			cl.setPhone(rs.getString("cl.phone"));
			cl.setNotes(rs.getNString("cl.notes"));
			cl.setOverdue(rs.getString("overdue"));
			System.out.println(cl);
			list.add(cl);
		}
		rs.close();
		stmt.close();
		System.out.println("CustomerDao종료!!!");
		return list;
	}
	//고객 리스트 총 개수 출력
	public int selectCustomerListCount(Connection conn)throws Exception {
		int count=0;
		PreparedStatement stmt = conn.prepareStatement(CustomerQuery.SELECT_CUSTOMER_LIST_COUNT);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			count= rs.getInt("count(*)");
		}
		rs.close();
		stmt.close();
		return count;
	}
	
	
}
