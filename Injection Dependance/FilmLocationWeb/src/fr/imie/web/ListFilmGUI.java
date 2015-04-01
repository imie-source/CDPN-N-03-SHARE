/**
 * 
 */
package fr.imie.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.imie.Iservice.FilmServiceInterface;
import fr.imie.dto.FilmDTO;
import fr.imie.service.qualifier.American;
import fr.imie.service.qualifier.French;

/**
 * @author imie
 *
 */
@SessionScoped
@Named("listFilmGUI")
public class ListFilmGUI implements Serializable{
	private List<FilmDTO> filmFr;
	private List<FilmDTO> filmUs;
	
	public List<FilmDTO> getFilmUS() {
		return filmUs;
	}
	public List<FilmDTO> getFilmFR() {
		return filmFr;
	}
	public void setFilmFr(List<FilmDTO> filmFr) {
		this.filmFr = filmFr;
	}
	public void setFilmUs(List<FilmDTO> filmUs) {
		this.filmUs = filmUs;
	}

    
	
	

}
