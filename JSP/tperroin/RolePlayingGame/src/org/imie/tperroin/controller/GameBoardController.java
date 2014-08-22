package org.imie.tperroin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imie.tperroin.model.Personnage;

/**
 * Servlet implementation class GameBoardController
 */
@WebServlet("/GameBoardController")
public class GameBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/GameBoard.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movement = request.getParameter("movement");
		
		request.setAttribute("movement", movement);
		
		Personnage personnageConnected = (Personnage) request.getSession().getAttribute("personnageConnected");
		
		try {
			Integer position = personnageConnected.getCurrentCell().getNum();
			
			if("LEFT".equals(movement)) {
				setPositionPersonnage(personnageConnected, position  - 1) ;
			}
			if("TOP".equals(movement)) {
				setPositionPersonnage(personnageConnected, position  - 10) ;
			}
			if("RIGHT".equals(movement)) {
				setPositionPersonnage(personnageConnected, position  + 1) ;
			}
			if("DOWN".equals(movement)) {
				setPositionPersonnage(personnageConnected, position  + 10) ;
			}
		} catch (IndexOutOfBoundsException ie) {
			System.out.println("erreur");
		}
		
		request.getRequestDispatcher("WEB-INF/GameBoard.jsp").forward(request, response);
		
	}

	private void setPositionPersonnage(Personnage personnageConnected, Integer position) {
		
		personnageConnected.setCurrentCell(personnageConnected.getGameBoard().getCells().get(position));
		
	}

}
