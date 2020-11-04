package sakila.Query;

public class FilmQuery {
	public static final String SELECT_FILM_LIST 
	= "select fl.FID, fl.category, fl.title, l.name, fl.rating, fl.price from film_list fl inner join film  f on fl.FID = f.film_id inner join language  l on f.language_id = l.language_id order by FID asc limit ?, ?"; 

	public static final String SELECT_FILM_LIST_INVENTORYCOUNT
	= "select fl.FID, fl.category, fl.title, l.name, fl.rating, count(i.film_id) count from film_list fl inner join film f on fl.FID = f.film_id inner join language l on f.language_id = l.language_id inner join inventory i on f.film_id = i.film_id group by i.film_id order by FID asc limit ?, ?";
}
