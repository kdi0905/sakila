package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.Query.ActorQuery;
import sakila.vo.Actor;

public class ActorDao {
		
	public List<Actor> selectActorList(Connection conn) throws Exception{
		List<Actor> list = new ArrayList<Actor>();
		Actor actor = null;
		PreparedStatement stmt = conn.prepareStatement(ActorQuery.SELECT_ACTOR_LIST);
		ResultSet rs =stmt.executeQuery();
		while (rs.next()) {
			actor = new Actor();
			actor.setActorId(rs.getInt("actor_id"));
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));
			list.add(actor);
		}
		 rs.close();
		 stmt.close();
		return list;
	}
}
