package sakila.Query;

public class CustomerQuery {
	public static final String SELECT_CUSTOMER_LIST
	="SELECT c.customer_id,c.first_name,c.last_name,c.active, a.address, a.phone FROM customer c INNER JOIN address a ON c.address_id= a.address_id order BY c.create_date DESC limit ?,? ";
}
