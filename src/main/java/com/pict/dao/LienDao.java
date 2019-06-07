package com.pict.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.pict.entity.Lien;

@Repository
public class LienDao {
	@Autowired
	private Database database;
	
	public Lien findByIds(int idevenement,int idlieu,int idmedia,int idpersonne) {
		Lien l = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select idevenement,idlieu,idmedia,idpersonne from contact where idevenement=?,idlieu=?;idmedia=?,idpersonne=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, idevenement);
			ps.setInt(2, idlieu);
			ps.setInt(3, idmedia);
			ps.setInt(4, idpersonne);

			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				l= new Lien(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4));
			}
						
			rs.close();
			ps.close();
		
			} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return l;
	}

	
	public long Save(Lien l) {
		long result = 0;
		
		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "INSERT INTO EVENEMENT (idevenement,idlieu,idmedia,idpersonne) VALUES (?,?,?,?) "
					+ "ON DUPLICATE KEY UPDATE idevenement=VALUES(idevenement),idlieu=VALUES(idlieu);idmedia=VALUES(idmedia),idpersonne=VALUES(idpersonne)";

			//System.out.println(sql);
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, l.getIdevenement());
			ps.setInt(2, l.getIdlieu());
			ps.setInt(3, l.getIdmedia());
			ps.setInt(4, l.getIdpersonne());
			
			ps.executeUpdate();

			ResultSet rspk = ps.getGeneratedKeys();
			while (rspk.next()) {
				result = rspk.getLong(1);
			}
			rspk.close();

			ps.close();
			
			//si result=0: c'est un update, renvoie l'id modifié
			if (result==0)
				result=l.getIdevenement();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			result = 0;
		}

		return result;
	}

}
