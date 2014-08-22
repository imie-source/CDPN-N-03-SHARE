package imie.org.servlet;

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
 * Servlet implementation class TP9Connexion
 */
@WebServlet("/Connexion")
public class TP9Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP9Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commande = request.getParameter("commande");
		HttpSession session = request.getSession();
		String idString;
		Integer id;

		List<Personnage> personnages;
		if (commande != null) {
			switch (commande) {
			case "connexion":
				idString = request.getParameter("id");
				id = Integer.valueOf(idString);
				personnages = (List<Personnage>) session
						.getAttribute("personnages");
				Personnage personnageToConnect = null;
				for (Personnage personnage : personnages) {
					if (id == personnage.getId()) {
						personnageToConnect = personnage;
						break;
					}
				}
				session.setAttribute("personnageConnecte", personnageToConnect);
				response.sendRedirect("./ListPersonnage");

			default:
				break;
			}
		} else {
			request.setAttribute("notConnected", true);
			display(request, response, session);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void display(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		request.setAttribute("personnages", session.getAttribute("personnages"));
		request.getRequestDispatcher("WEB-INF/listePersonnage.jsp").forward(
				request, response);
	}

}
