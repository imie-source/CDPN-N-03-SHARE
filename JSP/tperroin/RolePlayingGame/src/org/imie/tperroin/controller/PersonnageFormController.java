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
 * Servlet implementation class PersonnageFormController
 */
@WebServlet("/PersonnageFormController")
public class PersonnageFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonnageFormController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Personnage> persoList =  (ArrayList<Personnage>) request.getSession().getAttribute("persoList");
		
		if (request.getParameter("commande") == null || request.getParameter("commande").compareTo("add") != 0) {
			for (Personnage personnage : persoList) {
				if(Integer.valueOf(request.getParameter("id")) == personnage.getId()) {
					request.setAttribute("persoToView", personnage);
					break;
				}
			}
		}
		
		request.getRequestDispatcher("WEB-INF/PersonnageForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Personnage> persoList =  (ArrayList<Personnage>) request.getSession().getAttribute("persoList");
		
		if (request.getParameter("new") != null) {
			
			String persoName = request.getParameter("name");
			Personnage newPersonnage = new Personnage();
			newPersonnage.setName(persoName);
			
			persoList.add(newPersonnage);
			request.setAttribute("persoList", persoList);
			
			response.sendRedirect("./PersonnageController");
			
		} else {
			
			String persoId = request.getParameter("persoId");
			String persoName = request.getParameter("name");
			String persoImage = request.getParameter("image");
			
			Personnage personnageToUpdate=null;
			for (Personnage personnage : persoList) {
				if(Integer.valueOf(persoId) == personnage.getId()) {
					personnage.setName(persoName);
					personnage.setImage(persoImage);
					personnageToUpdate = personnage;
					break;
				}
			}
			
			request.setAttribute("persoList", persoList);
			response.sendRedirect("./PersonnageController");
			
		}
	}

}
