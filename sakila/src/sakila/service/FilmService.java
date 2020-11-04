package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import sakila.commons.DBUtil;
import sakila.dao.FilmDao;
import sakila.vo.FilmList;

public class FilmService {
	private FilmDao filmDao;
	public List<FilmList> getFilmList(int currentPage,int rowPerPage){
		System.out.println("FilmService 접속성공");
		System.out.println("getFilmList 실행");
		Connection conn = null;
		List<FilmList> list =null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn=dbUtil.selectDB();
			int beginRow = (currentPage-1)*rowPerPage;
			conn.setAutoCommit(false);
			filmDao = new FilmDao();
			list = filmDao.selectFilmList(conn, beginRow, rowPerPage);
			
			conn.commit();
		}catch(Exception e){
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
		System.out.println("getFilmList 종료");
		System.out.println("FilmService 접속종료");
		return list;
	}
	
	public List<FilmList> getFilmInventoryList(int currentPage,int rowPerPage){
		System.out.println("FilmService 접속성공");
		System.out.println("getFilmInventoryList 실행");
		Connection conn = null;
		List<FilmList> list =null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn=dbUtil.selectDB();
			int beginRow = (currentPage-1)*rowPerPage;
			conn.setAutoCommit(false);
			filmDao = new FilmDao();
			list = filmDao.selectFilmInventoryList(conn, beginRow, rowPerPage);
			
			conn.commit();
		}catch(Exception e){
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
		System.out.println("getFilmInventoryList 종료");
		System.out.println("FilmService 접속종료");
		return list;
	}
}
