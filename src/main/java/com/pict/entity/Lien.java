package com.pict.entity;

public class Lien {
	int idmedia;
	int idpersonne;
	int idlieu;
	int idevenement;
	public int getIdmedia() {
		return idmedia;
	}
	public void setIdmedia(int idmedia) {
		this.idmedia = idmedia;
	}
	public int getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}
	public int getIdlieu() {
		return idlieu;
	}
	public void setIdlieu(int idlieu) {
		this.idlieu = idlieu;
	}
	public int getIdevenement() {
		return idevenement;
	}
	public void setIdevenement(int idevenement) {
		this.idevenement = idevenement;
	}
	
	public Lien(int idmedia, int idpersonne, int idlieu, int idevenement) {
		
		this.idmedia = idmedia;
		this.idpersonne = idpersonne;
		this.idlieu = idlieu;
		this.idevenement = idevenement;
	}
	
	public Lien() {
		
	}
	

}
