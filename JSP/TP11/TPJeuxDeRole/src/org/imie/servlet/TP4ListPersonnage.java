package org.imie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.imie.model.Personnage;

/**
 * Servlet implementation class ListPersonnage
 */
@WebServlet("/ListPersonnage")
public class TP4ListPersonnage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TP4ListPersonnage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String commande = request.getParameter("commande");
		HttpSession session = request.getSession();
		String idString;
		Integer id;

		List<Personnage> personnages;
		if (commande != null) {
			switch (commande) {
			case "supprimer":
				idString = request.getParameter("id");
				id = Integer.valueOf(idString);

				personnages = (List<Personnage>) session
						.getAttribute("personnages");
				Personnage personnageToDelete = null;
				for (Personnage personnage : personnages) {
					if (id == personnage.getId()) {
						personnageToDelete = personnage;
						break;
					}
				}
				if (personnageToDelete != null) {
					personnages.remove(personnageToDelete);
				}

				session.setAttribute("personnages", personnages);
				display(request, response, session);
				break;
			case "editer":
				idString = request.getParameter("id");
				id = Integer.valueOf(idString);
				response.sendRedirect("./FormPersonnage?id=".concat(String
						.valueOf(id)));
				break;
			case "creer":
				response.sendRedirect("./FormPersonnage?commande=creer");
				break;
			default:
				break;
			}
		} else {
			display(request, response, session);
		}

	}

	private void display(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		request.setAttribute("personnages", session.getAttribute("personnages"));
		request.getRequestDispatcher("WEB-INF/listePersonnage.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
