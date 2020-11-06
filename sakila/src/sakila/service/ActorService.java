package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.commons.DBUtil;
import sakila.dao.ActorDao;
import sakila.vo.Actor;

public class ActorService {
	public List<Actor> getSelectActorList() {
		System.out.println("ActorService 접속성공");
		Connection conn = null;
		List<Actor> list = new ArrayList<Actor>();
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn=dbUtil.selectDB();
			ActorDao actorDao = new ActorDao();
			conn.setAutoCommit(false);
			list =  actorDao.selectActorList(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
