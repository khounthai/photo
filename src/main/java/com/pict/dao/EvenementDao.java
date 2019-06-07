package com.pict.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.pict.entity.Evenement;

@Repository
public class EvenementDao {
	
	@Autowired
	private Database database;

	public List<Evenement> getListEvenementfindById(List<Integer> listId) {

		List<Evenement> liste = new ArrayList<Evenement>();
		
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

	
	public List<Evenement> getListEvenementfindByNom(List<String> listeNom) {

		List<Evenement> liste = new ArrayList<Evenement>();
		
		try {
			for (String item:listeNom) {
				liste.add(findByNom(item));
			}
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}
	
	public Evenement findByNom(String nom) {
		Evenement e = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,nom from contact where nom=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, nom);

			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e= new Evenement(rs.getInt(1), rs.getString(2));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return e;
	}


	public Evenement findById(int id) {
		Evenement e = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,nom from contact where id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);

			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e= new Evenement(rs.getInt(1), rs.getString(2));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return e;
	}
	
	public long Save(Evenement e) {
		long result = 0;
		
		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "INSERT INTO EVENEMENT (id,nom) VALUES (?,?) "
					+ "ON DUPLICATE KEY UPDATE id=VALUES(id), nom=VALUES(nom)";

			//System.out.println(sql);
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, e.getId());
			ps.setString(2, e.getNom());
			
			ps.executeUpdate();

			ResultSet rspk = ps.getGeneratedKeys();
			while (rspk.next()) {
				result = rspk.getLong(1);
			}
			rspk.close();

			ps.close();
			
			//si result=0: c'est un update, renvoie l'id modifié
			if (result==0)
				result=e.getId();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			result = 0;
		}

		return result;
	}

}
