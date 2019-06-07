package com.pict.entity;

public class Lieu {
	int id;
	String nom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Lieu(int id, String nom) {
		
		this.id = id;
		this.nom = nom;
	}
	
	public Lieu() {
		
	}
	
	@Override
	public String toString() {
		return  nom ;
	}
	
}
