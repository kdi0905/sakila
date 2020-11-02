package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.Query.RentalQuery;
import sakila.vo.Customer;
import sakila.vo.Rental;

public class RentalDao {
	//고객이 연체한 영화가 있는지 확인

	public List<Rental> selectRentalCheck(Connection conn,int customerId)throws Exception{
		System.out.println("RentalDao 접속 성공");
		List<Rental> list =null;	
		Rental rental = null;
		PreparedStatement stmt= conn.prepareStatement(RentalQuery.SELECT_RENTAL_FILM_BY_CUSTOMER);
		stmt.setInt(1, customerId);
		ResultSet rs = stmt.executeQuery();
		
		
		if(rs.next()) {
			list = new ArrayList<Rental>();
		}
		while (rs.next()) {
			rental = new Rental();
			rental.setCustomerId(rs.getInt("r.customer_id"));
			rental.setRental_id(rs.getInt("r.rental_id"));
			rental.setInventoryId(rs.getInt("r.inventory_id"));
			list.add(rental);
		}
		System.out.println("RentalDao 접속 종료");
		return list;
	}
}
