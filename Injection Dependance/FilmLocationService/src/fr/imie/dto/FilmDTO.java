/**
 * 
 */
package fr.imie.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO d'un film
 * @author imie
 *
 */
public class FilmDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9122108279212697994L;
	
	private Integer id;
	private String titre;
	private String genre;
	private Date dateSortie;
	private Integer duree;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
