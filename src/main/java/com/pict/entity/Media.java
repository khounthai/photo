package com.pict.entity;

public class Media {
	int id;
	String chemin;
	String commentaire;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Media(int id, String chemin, String commentaire) {
		super();
		this.id = id;
		this.chemin = chemin;
		this.commentaire = commentaire;
	}
		
		
	public Media() {
		
	}
	
}
