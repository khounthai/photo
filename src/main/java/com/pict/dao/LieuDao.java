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
import com.pict.entity.Evenement;
import com.pict.entity.Lieu;

@Repository
public class LieuDao {
	@Autowired
	private Database database;

	public List<Lieu> getListLieufindById(List<Integer> listId) {

		List<Lieu> liste = new ArrayList<Lieu>();
		
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

	
	public List<Lieu> getListLieufindByNom(List<String> listeNom) {

		List<Lieu> liste = new ArrayList<Lieu>();
		
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
	
	public Lieu findByNom(String nom) {
		Lieu l = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,nom from lieu where nom=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, nom);

			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				l= new Lieu(rs.getInt(1), rs.getString(2));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return l;
	}


	public Lieu findById(int id) {
		Lieu e = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,nom from contact where id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);

			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e= new Lieu(rs.getInt(1), rs.getString(2));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return e;
	}
	
	public List<Lieu> Autocomplete(String term) {
		List<Lieu> liste = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,nom from lieu where nom like ?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, "%"+term+"%");

			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			liste=new ArrayList<Lieu>();
			
			while (rs.next()) {				
				liste.add( new Lieu(rs.getInt(1),rs.getString(2)));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}

	
	
	public long Save(Lieu l) {
		long result = 0;
		
		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "INSERT INTO LIEU (id,nom) VALUES (?,?) "
					+ "ON DUPLICATE KEY UPDATE id=VALUES(id), nom=VALUES(nom)";

			//System.out.println(sql);
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, l.getId());
			ps.setString(2, l.getNom());
			
			ps.executeUpdate();

			ResultSet rspk = ps.getGeneratedKeys();
			while (rspk.next()) {
				result = rspk.getLong(1);
			}
			rspk.close();

			ps.close();
			
			//si result=0: c'est un update, renvoie l'id modifié
			if (result==0)
				result=l.getId();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			result = 0;
		}

		return result;
	}

}
