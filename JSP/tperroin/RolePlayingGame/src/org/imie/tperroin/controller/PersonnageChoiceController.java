package org.imie.tperroin.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imie.tperroin.model.Cell;
import org.imie.tperroin.model.GameBoard;
import org.imie.tperroin.model.Personnage;

/**
 * Servlet implementation class PersonnageChoiceController
 */
@WebServlet("/PersonnageChoiceController")
public class PersonnageChoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonnageChoiceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("persoList") == null) {
			
			ArrayList<Personnage> persoList = new ArrayList<Personnage>();
			Personnage perso1 = (Personnage) request.getSession().getAttribute("perso1"); 
			Personnage perso2 = (Personnage) request.getSession().getAttribute("perso2");
			Personnage perso3 = (Personnage) request.getSession().getAttribute("perso3");
			Personnage perso4 = (Personnage) request.getSession().getAttribute("perso4");
			Personnage perso5 = (Personnage) request.getSession().getAttribute("perso5");
			
			perso1.setName("tperroin");
			perso1.setBirthday(LocalDate.now());
			perso1.setHp(100); 
			perso1.setExp(new Long(5000));
			perso1.setGameBoard(new GameBoard());
			perso1.getGameBoard().setCells(new ArrayList<Cell>());
	
			perso2.setName("fdurieux");
			perso2.setBirthday(LocalDate.now());
			perso2.setHp(100); 
			perso2.setExp(new Long(0));
			perso2.setGameBoard(new GameBoard());
			perso2.getGameBoard().setCells(new ArrayList<Cell>());
	
			perso3.setName("ddenis");
			perso3.setBirthday(LocalDate.now());
			perso3.setHp(100);
			perso3.setExp(new Long(0));
			perso3.setGameBoard(new GameBoard());
			perso3.getGameBoard().setCells(new ArrayList<Cell>());
	
			perso4.setName("pchabbert");
			perso4.setBirthday(LocalDate.now());
			perso4.setHp(100);
			perso4.setExp(new Long(0));
			perso4.setGameBoard(new GameBoard());
			perso4.getGameBoard().setCells(new ArrayList<Cell>());
			
			perso5.setName("pbouvier");
			perso5.setBirthday(LocalDate.now());
			perso5.setHp(100);
			perso5.setExp(new Long(0));
			perso5.setGameBoard(new GameBoard());
			perso5.getGameBoard().setCells(new ArrayList<Cell>());
			
			persoList.add(0, perso1);
			persoList.add(1, perso2);
			persoList.add(2, perso3);
			persoList.add(3, perso4);
			persoList.add(4, perso5);
			
			request.getSession().setAttribute("persoList", persoList);
		}
		
		request.getRequestDispatcher("WEB-INF/PersonnageList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String logoutAction = request.getParameter("logout");
		if(logoutAction != null) {
			request.getSession().removeAttribute("personnageConnected");
			request.getRequestDispatcher("WEB-INF/PersonnageList.jsp").forward(request, response);
			
		}else{
			
			request.setAttribute("logged", true);
			
			ArrayList<Personnage> persoList =  (ArrayList<Personnage>) request.getSession().getAttribute("persoList");
			String persoId = request.getParameter("persoId");
			
			
			Personnage personnageConnected=null;
			for(Personnage personnage : persoList) {
				if(Integer.valueOf(persoId) == personnage.getId()) {
					personnageConnected = personnage;
					break;
				}
			}
			
			request.getSession().setAttribute("personnageConnected", personnageConnected);
			response.sendRedirect("./PersonnageController");
		}
	}

}
