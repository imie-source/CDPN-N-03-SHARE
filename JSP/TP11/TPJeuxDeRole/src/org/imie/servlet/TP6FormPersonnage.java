package org.imie.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.imie.model.Personnage;

/**
 * Servlet implementation class FormPersonnage
 */
@WebServlet("/FormPersonnage")
public class TP6FormPersonnage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TP6FormPersonnage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("modeCreation", null);
		// récupération de l'id à éditer
		String idString = request.getParameter("id");
		if (idString != null) {
			Personnage personnageById = null;
			Integer id = Integer.valueOf(idString);

			// recherche du personnage à éditer
			List<Personnage> personnages = (List<Personnage>) session
					.getAttribute("personnages");
			for (Personnage personnage : personnages) {
				if (id == personnage.getId()) {
					personnageById = personnage;
					break;
				}
			}

			request.setAttribute("personnage", personnageById);
		} else {
			Personnage nouveauPersonnage = new Personnage();
			nouveauPersonnage.setExp(Double.valueOf(0));
			nouveauPersonnage.setHp(Double.valueOf(100));
			nouveauPersonnage.setDateCreation(new Date());
			request.setAttribute("personnage", nouveauPersonnage);
			request.setAttribute("modeCreation", true);
		}
		// forward vers la vue
		request.getRequestDispatcher("WEB-INF/formPersonnage.jsp").forward(
				request, response);
	}

	private Personnage findPersonnage(HttpSession session, String idString) {
		Personnage personnageById = null;
		Integer id = Integer.valueOf(idString);

		// recherche du personnage à éditer
		List<Personnage> personnages = (List<Personnage>) session
				.getAttribute("personnages");
		for (Personnage personnage : personnages) {
			if (id == personnage.getId()) {
				personnageById = personnage;
				break;
			}
		}
		return personnageById;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		// récupération de l'id à éditer
		String idString = request.getParameter("id");
		String commande = request.getParameter("commande");
		// recherche du personnage à éditer
		List<Personnage> personnages = (List<Personnage>) session
				.getAttribute("personnages");
		switch (commande) {
		case "modifier":
			Personnage personnageById = null;
			Integer id = Integer.valueOf(idString);

			for (Personnage personnage : personnages) {
				if (id == personnage.getId()) {
					personnageById = personnage;
					break;
				}
			}
			personnageById.setNom(request.getParameter("nomPersonnage"));
			personnageById.setExp(Double.valueOf(request
					.getParameter("expPersonnage")));
			personnageById.setHp(Double.valueOf(request
					.getParameter("HPPersonnage")));

			session.setAttribute("personnages", personnages);
			break;
		case "creer":
			Personnage nouveauPersonnage = new Personnage();
			nouveauPersonnage.setNom(request.getParameter("nomPersonnage"));
			String expPersonnageString = request.getParameter("expPersonnage");
			nouveauPersonnage.setExp(expPersonnageString == null ? 0 : Double
					.valueOf(expPersonnageString));
			String HPPersonnageString = request.getParameter("HPPersonnage");
			nouveauPersonnage.setHp(HPPersonnageString == null ? 0 : Double
					.valueOf(HPPersonnageString));
			nouveauPersonnage.setDateCreation(new Date());
			personnages.add(nouveauPersonnage);
			session.setAttribute("personnages", personnages);

			break;

		default:
			break;
		}

		response.sendRedirect("./ListPersonnage");
	}

}
