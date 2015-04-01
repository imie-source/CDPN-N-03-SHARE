/**
 * 
 */
package fr.imie.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import fr.imie.Iservice.FilmServiceInterface;
import fr.imie.dto.FilmDTO;
import fr.imie.service.qualifier.American;

/**
 * @author imie
 *
 */
@Named("american")
@American
public class AmericanFilmService implements FilmServiceInterface {

	/* (non-Javadoc)
	 * @see fr.imie.Iservice.FilmServiceInterface#getFilms()
	 */
	@Override
	public List<FilmDTO> getFilms() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		List<FilmDTO> films = new ArrayList<FilmDTO>();
		
		//création du DTO
		FilmDTO filmDTO1 = new FilmDTO();
		filmDTO1.setId(1);
		filmDTO1.setTitre("Ali G");
		filmDTO1.setDuree(120);
		filmDTO1.setGenre("humour");
		Date dateSortie=null;
		try {
			dateSortie = simpleDateFormat.parse("01/01/2003");
		} catch (ParseException e) {
			//not necessary to affect null to dateSortie
		}
		filmDTO1.setDateSortie(dateSortie);
		//ajout du DTO à la liste d'objet
		films.add(filmDTO1);
		
		
		FilmDTO filmDTO2 = new FilmDTO();
		filmDTO2.setId(2);
		filmDTO2.setTitre("American Pie");
		filmDTO2.setDuree(120);
		filmDTO2.setGenre("humour");
		Date dateSortie2=null;
		try {
			dateSortie2 = simpleDateFormat.parse("01/02/1997");
		} catch (ParseException e) {
			//not necessary to affect null to dateSortie
		}
		filmDTO2.setDateSortie(dateSortie2);
		films.add(filmDTO2);
		
		
		FilmDTO filmDTO3 = new FilmDTO();
		filmDTO3.setId(3);
		filmDTO3.setTitre("Fast And Furious");
		filmDTO3.setDuree(120);
		filmDTO3.setGenre("Action");
		Date dateSortie3=null;
		try {
			dateSortie3 = simpleDateFormat.parse("01/03/1979");
		} catch (ParseException e) {
			//not necessary to affect null to dateSortie
		}
		filmDTO3.setDateSortie(dateSortie3);
		films.add(filmDTO3);
		
		return films;
	}

}
