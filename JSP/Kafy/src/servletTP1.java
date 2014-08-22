

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Personnage;

/**
 * Servlet implementation class servletTP1
 */
@WebServlet("/servletTP1")
public class servletTP1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletTP1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "WEB-INF/TP1.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action= request.getParameter("action");
		String id = request.getParameter("id");
		
		System.out.println("action : "+ action);
		ArrayList<Personnage> listePersonnages = (ArrayList<Personnage>) request.getSession().getAttribute("listePersonnages");
		if(listePersonnages!=null){
			if ("Supprimer".equals(action)){
					Personnage persoToDelete= null;
					for (Personnage p : listePersonnages) {
						if(p.getId().equals(id)){
							persoToDelete = p;
							break;
						}
					}
					if (persoToDelete != null){
						System.out.println("suppression du perso nommé "+persoToDelete.getNom());
						listePersonnages.remove(persoToDelete);
					}
					request.getRequestDispatcher( "WEB-INF/TP1.jsp" ).forward( request, response );
			}
			
			if ("Afficher".equals(action)){
				response.sendRedirect("./servletFormulaire?id=".concat(id));
			}
			
		}else{
			System.out.println("LISTE NULL");
			request.getRequestDispatcher( "WEB-INF/Formulaire.jsp" ).forward( request, response );
		}
		
	}

}
