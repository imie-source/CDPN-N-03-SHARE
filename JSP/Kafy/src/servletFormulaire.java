

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Personnage;

/**
 * Servlet implementation class servletFormulaire
 */
@WebServlet("/servletFormulaire")
public class servletFormulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletFormulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		String id = request.getParameter("id");
		
		if(action==null){
			ArrayList<Personnage> listePersonnages = (ArrayList<Personnage>) request.getSession().getAttribute("listePersonnages");
			if(listePersonnages!=null){
			
				int placeListe = -1;
				for (int i=0; i<listePersonnages.size(); i++) {
					if(listePersonnages.get(i).getId().equals(id)){
						placeListe = i;
						break;
					}
				}
				
				if (placeListe!=-1){
					Personnage lePerso = listePersonnages.get(placeListe);
					request.setAttribute("lePerso", lePerso);
					request.setAttribute("action", "Modifier");
					request.getRequestDispatcher( "WEB-INF/Formulaire.jsp" ).forward( request, response );
				}	
			}
		}
		
		if("Creer".equals(action)){
			request.setAttribute("action", action);
			request.getRequestDispatcher( "WEB-INF/Formulaire.jsp" ).forward( request, response );
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		String id = request.getParameter("id");
		String nom = request.getParameter("nomPerso");
		
		ArrayList<Personnage> listePersonnages = (ArrayList<Personnage>) request.getSession().getAttribute("listePersonnages");
		if(listePersonnages!=null){
			//SI on est en modification
			if("Modifier".equals(action)){
				int placeListe = -1;
				for (int i=0; i<listePersonnages.size(); i++) {
					if(listePersonnages.get(i).getId().equals(id)){
						placeListe = i;
						break;
					}
				}
				
				if (placeListe!=-1){
					Personnage lePerso = listePersonnages.get(placeListe);
					lePerso.setNom(nom);
					response.sendRedirect( "servletTP1" );
				}	
			}
			
			//SI on est en création
			if("Creer".equals(action)){
				
				Date now = new Date();
				Personnage perso = new Personnage(nom, now);
				System.out.println("Creation du personnage nommé "+nom);
				
				listePersonnages.add(perso);

				response.sendRedirect( "servletTP1" );
			}
		}
		
		
	}

}
