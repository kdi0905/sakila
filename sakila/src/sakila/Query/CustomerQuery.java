package sakila.Query;

public class CustomerQuery {
	public final static String SELECT_CUSTOMER_LIST = "SELECT cl.ID, cl.name, cl.phone, cl.notes, IF((SELECT COUNT(*) FROM rental WHERE return_date IS NULL AND customer_id = cl.ID) > 0,'Y','N') AS overdue FROM customer_list cl ORDER BY cl.ID ASC LIMIT ?, ?";
}
