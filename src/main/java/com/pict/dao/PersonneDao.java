package com.pict.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.pict.entity.Evenement;
import com.pict.entity.Media;
import com.pict.entity.Personne;

@Repository
public class PersonneDao {
	@Autowired
	private Database database;

	public List<Personne> getListPersonnefindById(List<Integer> listId) {

		List<Personne> liste = new ArrayList<Personne>();

		try {
			for (Integer item : listId) {
				liste.add(findById(item.intValue()));
			}

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}

	public Personne findById(int id) {
		Personne p = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,prenom,nom from pesonne where id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);

			// System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Personne(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return p;
	}

	public List<Personne> getListPersonnefindByNom(List<String> listeNom) {

		List<Personne> liste = new ArrayList<Personne>();

		try {
			for (String item : listeNom) {
				liste.add(findByNom(item));
			}

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}

	public Personne findByNom(String nom) {
		Personne p = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,prenom,nom from personne where nom=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, nom);

			// System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Personne(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return p;
	}

	public List<Personne> getListPersonnefindByPrenom(List<String> listePrenom) {

		List<Personne> liste = new ArrayList<Personne>();

		try {
			for (String item : listePrenom) {
				liste.add(findByPrenom(item));
			}

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}

	public Personne findByPrenom(String prenom) {
		Personne p = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,prenom,nom from personne where prenom=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, prenom);

			// System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Personne(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return p;
	}

	
	public List<Personne> getListPersonnefindByPrenomNom(List<Personne> listePrenomNom) {

		List<Personne> liste = new ArrayList<Personne>();

		try {
			for (Personne item:listePrenomNom) {
				liste.add(findByPrenomNom(item.getPrenom(),item.getNom()));
			}

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}

	public Personne findByPrenomNom(String prenom,String nom) {
		Personne p = null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,prenom,nom from personne where prenom=?,nom=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, prenom);

			// System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Personne(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return p;
	}

	public List<Personne> getAllPersonne() {

		List<Personne> liste = new ArrayList<Personne>();
		Personne p=null;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select id,prenom,nom from personne order by nom,prenom";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			// System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Personne(rs.getInt(1), rs.getString(2), rs.getString(3));
				liste.add(p);
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}

	public List<String> getNoms() {

		List<String> liste = new ArrayList<String>();
		
		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select nom from personne";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			// System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				liste.add(rs.getString(1));
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}
	
	public List<Personne> Autocomplete(String term) {

		List<Personne> liste = new ArrayList<Personne>();
		Personne p=null;
		
		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "select * from personne where (nom like ?) or (prenom like ?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,  term + "%");
			ps.setString(2,  term + "%");
			
			//System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				p = new Personne(rs.getInt(1), rs.getString(2), rs.getString(3));
				liste.add(p);
			}

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return liste;
	}
	
	public long Save(Personne p) {
		long result = 0;

		try {
			Connection conn = (Connection) database.getSqlConnection();

			String sql = "INSERT INTO MEDIA (id,chemin,commentaire) VALUES (?,?,?) "
					+ "ON DUPLICATE KEY UPDATE id=VALUES(id), chemin=VALUES(chemin), commentaire=VALUES(commentaire)";

			// System.out.println(sql);
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, p.getId());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getNom());

			ps.executeUpdate();

			ResultSet rspk = ps.getGeneratedKeys();
			while (rspk.next()) {
				result = rspk.getLong(1);
			}
			rspk.close();

			ps.close();

			// si result=0: c'est un update, renvoie l'id modifié
			if (result == 0)
				result = p.getId();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			result = 0;
		}

		return result;
	}
}
