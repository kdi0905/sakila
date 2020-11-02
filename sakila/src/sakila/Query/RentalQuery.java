package sakila.Query;

public class RentalQuery {
	//고객이 연체한 영화가 있는지 확인
	public static final String SELECT_RENTAL_FILM_BY_CUSTOMER =
			"SELECT r.customer_id, r.rental_id, r.inventory_id, f.title,r.rental_date,date_add(r.rental_date, INTERVAL f.rental_duration DAY) dateAdd FROM inventory i inner join rental r on i.inventory_id= r.inventory_id inner join film f on i.film_id= f.film_id WHERE r.return_date>date_add(r.rental_date, INTERVAL f.rental_duration DAY)&& r.customer_id =?";//반납해야될  날짜가 고객이 반납한 날짜보다 작으면 연체(yes) 없으면 (no)
		
	
}
