/**
 * 
 */
package org.imie.model;

import java.util.Date;

/**
 * @author imie
 *
 */
public class Personnage {

	private String nom;
	private Date dateCreation;
	private Double exp;
	private Double hp;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Double getExp() {
		return exp;
	}
	public void setExp(Double exp) {
		this.exp = exp;
	}
	public Double getHp() {
		return hp;
	}
	public void setHp(Double hp) {
		this.hp = hp;
	}
	
	
	
}
