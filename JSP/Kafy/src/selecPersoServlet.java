

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Personnage;

/**
 * Servlet implementation class selecPersoServlet
 */
@WebServlet("/selecPersoServlet")
public class selecPersoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selecPersoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getSession().getAttribute("persoSelec")== null){
			request.setAttribute("login" , true );
		}
		
		request.getRequestDispatcher( "WEB-INF/TP1.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionHeader = request.getParameter("actionHeader");
		
		System.out.println(actionHeader);
		if("Jouer".equals(actionHeader)){
			response.sendRedirect("servletPlateau");
		}else {
			if("Deconnexion".equals(actionHeader)){
				request.getSession().removeAttribute("persoSelec");
			}else{
				String id = request.getParameter("id");
				Personnage persoLogged=new Personnage();
				ArrayList<Personnage> listePersonnages = (ArrayList<Personnage>) request.getSession().getAttribute("listePersonnages");
				for (Personnage p : listePersonnages) {
					if(p.getId().equals(id)){
						persoLogged = p;
						break;
					}
				}
				request.getSession().setAttribute("persoSelec", persoLogged);
			}
			request.getRequestDispatcher( "WEB-INF/TP1.jsp" ).forward( request, response );
		}
	}

}
