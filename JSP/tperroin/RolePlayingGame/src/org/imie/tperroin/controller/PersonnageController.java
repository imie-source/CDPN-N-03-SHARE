package org.imie.tperroin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imie.tperroin.model.Personnage;

/**
 * Servlet implementation class PersonnageController
 */
@WebServlet("/PersonnageController")
public class PersonnageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonnageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.getRequestDispatcher("WEB-INF/PersonnageList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String persoId = request.getParameter("persoId");
		String viewAction = request.getParameter("view");
		String deleteAction = request.getParameter("delete");
		String addAction = request.getParameter("add");
		String chooseAction = request.getParameter("choice");
		String playAction = request.getParameter("play");
		ArrayList<Personnage> persoList =  (ArrayList<Personnage>) request.getSession().getAttribute("persoList");
		
		if(playAction != null) {
			response.sendRedirect("./GameBoardController");
		}
		
		if (chooseAction != null) {
			request.getSession().setAttribute("logged", true);
		}
		
		if (viewAction != null) {
			response.sendRedirect("./PersonnageFormController?id=".concat(persoId));
		}
		
		if(addAction != null) {
			response.sendRedirect("./PersonnageFormController?commande=add");
		}
		
		if (deleteAction != null) {
			Personnage personnageToDelete=null;
			for(Personnage personnage : persoList) {
				if(Integer.valueOf(persoId) == personnage.getId()) {
					personnageToDelete = personnage;
					break;
				}
			}
			if(personnageToDelete != null) {
				persoList.remove(personnageToDelete);
			}
			request.getSession().setAttribute("persoList", persoList);
			request.getRequestDispatcher("WEB-INF/PersonnageList.jsp").forward(request, response);
		}
	
	}

}
