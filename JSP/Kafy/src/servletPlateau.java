

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Personnage;
import metier.Plateau;

/**
 * Servlet implementation class servletPlateau
 */
@WebServlet("/servletPlateau")
public class servletPlateau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPlateau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "WEB-INF/plateau.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deplacement = request.getParameter("deplacement");
		Personnage persoLogged = (Personnage) request.getSession().getAttribute("persoSelec");
		
		int x = persoLogged.getX();
		int y = persoLogged.getY();
		int newX= persoLogged.getX();
		int newY= persoLogged.getY();
		
		Plateau plateau = persoLogged.getPlateau();
		
		plateau.addElement(x, y, 0);
		
		if("gauche".equals(deplacement)){
			newY-=1;
		}
		if("droite".equals(deplacement)){
			newY+=1;
		}
		if("haut".equals(deplacement)){
			newX-=1;
		}
		if("bas".equals(deplacement)){
			newX+=1;
		}
		
		if (plateau.getTabPlateau()[newX][newY].getIdElement() != 10 ) {
			
			plateau.addElement(newX, newY, 1);
			
			persoLogged.setX(newX);
			persoLogged.setY(newY);
		}else{
			plateau.addElement(x, y, 1);
		}
		
		request.getRequestDispatcher( "WEB-INF/plateau.jsp" ).forward( request, response );
	}

}
