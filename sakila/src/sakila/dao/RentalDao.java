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
	public List<Rental> selectRentalCheck(Connection conn,Customer customer)throws Exception{
		List<Rental> list = new ArrayList<Rental>();
		Rental rental = null;
		PreparedStatement stmt= conn.prepareStatement(RentalQuery.SELECT_RENTAL_DEFAULT_CHECK);
		stmt.setInt(1, customer.getCustomerId());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			rental = new Rental();
			rental.setCustomerId(rs.getInt("r.customer_id"));
			rental.setRental_id(rs.getInt("r.rental_id"));
			rental.setInventoryId(rs.getInt("r.inventory_id"));
			list.add(rental);
		}
		return list;
	}
}
