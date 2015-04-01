package fr.imie.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import fr.imie.Iservice.FilmServiceInterface;
import fr.imie.dto.FilmDTO;
import fr.imie.service.qualifier.American;
import fr.imie.service.qualifier.French;

/**
 * Servlet implementation class FilmServlet
 */
@WebServlet("/films/*")
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UrlToLanguage urlToLanguage;
	@Inject
	private ListFilmGUI listFilmGUI;
	@Inject
	@American
	private FilmServiceInterface filmServiceUS;
	@Inject
	@French
	private FilmServiceInterface filmServiceFR;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		urlToLanguage.languageIdentification();

		List<FilmDTO> filmsFR = listFilmGUI.getFilmFR();
		if (filmsFR == null) {
			listFilmGUI.setFilmFr(filmServiceFR.getFilms());
		}

		List<FilmDTO> filmsUS = listFilmGUI.getFilmUS();
		if (filmsUS == null) {
			listFilmGUI.setFilmUs(filmServiceUS.getFilms());
		}

		request.getRequestDispatcher("/WEB-INF/films.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		urlToLanguage.languageIdentification();
		
		String titre = request.getParameter("titre");
		FilmDTO filmDTO = new FilmDTO();
		filmDTO.setTitre(titre);
		List<FilmDTO> films=null;
		if(urlToLanguage.getLanguage().equals(Language.fr)){
			films = listFilmGUI.getFilmFR();
		}
		if(urlToLanguage.getLanguage().equals(Language.us)){
			films = listFilmGUI.getFilmUS();
		}
		films.add(filmDTO);

		request.getRequestDispatcher("/WEB-INF/films.jsp").forward(request,
				response);

	}

}
