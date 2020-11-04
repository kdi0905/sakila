package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.Query.FilmQuery;
import sakila.vo.FilmList;

public class FilmDao {
	
	public List<FilmList> selectFilmList(Connection conn,final int BEGIN_ROW,final int ROW_PER_PAGE)throws Exception{
		System.out.println("FilmDao 접속성공");
		List<FilmList> list=new ArrayList<FilmList>();
		FilmList filmList = null;
		PreparedStatement stmt= conn.prepareStatement(FilmQuery.SELECT_FILM_LIST);
		//select fl.FID, fl.category, fl.title, l.name, fl.rating, fl.price from film_list as fl 
		//inner join film AS f on fl.FID = f.film_id inner join language AS l on f.language_id = l.language_id order by FID asc limit ?, ?
		stmt.setInt(1, BEGIN_ROW);
		stmt.setInt(2,ROW_PER_PAGE);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			filmList = new FilmList();
			filmList.setFID(rs.getInt("fl.FID"));
			filmList.setCategory(rs.getString("fl.category"));
			filmList.setTitle(rs.getString("fl.title"));
			filmList.setLanguage(rs.getString("l.name"));
			filmList.setRating(rs.getString("fl.rating"));
			filmList.setPrice(rs.getInt("fl.price"));
			list.add(filmList);
		}
		rs.close();
		stmt.close();
		System.out.println("FilmDao 접속종료");
		return list;
	}
	
	public List<FilmList> selectFilmInventoryList(Connection conn,final int BEGIN_ROW,final int ROW_PER_PAGE)throws Exception{
		System.out.println("FilmDao 접속성공");
		List<FilmList> list=new ArrayList<FilmList>();
		FilmList filmList = null;
		PreparedStatement stmt = conn.prepareStatement(FilmQuery.SELECT_FILM_LIST_INVENTORYCOUNT);
		//select fl.FID, fl.category, fl.title, l.name, fl.rating, count(i.film_id) count from film_list fl inner join film f on fl.FID = f.film_id inner join language l on f.language_id = l.language_id inner join inventory i on f.film_id = i.film_id group by i.film_id order by FID asc limit ?, ?"
		stmt.setInt(1, BEGIN_ROW);
		stmt.setInt(2,ROW_PER_PAGE);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			filmList = new FilmList();
			filmList.setFID(rs.getInt("fl.FID"));
			filmList.setCategory(rs.getString("fl.category"));
			filmList.setTitle(rs.getString("fl.title"));
			filmList.setLanguage(rs.getString("l.name"));
			filmList.setRating(rs.getString("fl.rating"));
			filmList.setInventoryCount(rs.getInt("count"));
			list.add(filmList);
		}
		rs.close();
		stmt.close();
		System.out.println("FilmDao 접속종료");
		return list;
	}
}
