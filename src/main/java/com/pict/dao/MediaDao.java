package com.pict.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.pict.entity.Lieu;
import com.pict.entity.Media;

@Repository
public class MediaDao {
	@Autowired
	private Database database;

	public List<Media> getListMediafindById(List<Integer> listId) {

		List<Media> liste = new ArrayList<Media>();
		
		try {
			for (Integer item:listId) {
				liste.add(findById(item.intValue()));
			}
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}

	
public Media findById(int id) {
		Media m = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,chemin,commentaire from media where id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);

			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				m= new Media(rs.getInt(1), rs.getString(2),rs.getString(3));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return m;
	}
	
	public long Save(Media m) {
		long result = 0;
		
		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "INSERT INTO MEDIA (id,chemin,commentaire) VALUES (?,?,?) "
					+ "ON DUPLICATE KEY UPDATE id=VALUES(id), chemin=VALUES(chemin), commentaire=VALUES(commentaire)";

			//System.out.println(sql);
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, m.getId());
			ps.setString(2, m.getChemin());
			ps.setString(3, m.getCommentaire());
			
			ps.executeUpdate();

			ResultSet rspk = ps.getGeneratedKeys();
			while (rspk.next()) {
				result = rspk.getLong(1);
			}
			rspk.close();

			ps.close();
			
			//si result=0: c'est un update, renvoie l'id modifié
			if (result==0)
				result=m.getId();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			result = 0;
		}

		return result;
	}
}
