package org.imie.tperroin.listeners;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.imie.tperroin.model.Personnage;

/**
 * Application Lifecycle Listener implementation class PersonnageListener
 *
 */
@WebListener
public class PersonnageListener implements HttpSessionListener {


	/**
     * Default constructor. 
     */
    public PersonnageListener() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent session)  { 
    		Personnage perso1 = new Personnage();
    		Personnage perso2 = new Personnage();
    		Personnage perso3 = new Personnage();
    		Personnage perso4 = new Personnage();
    		Personnage perso5 = new Personnage();
    		
    		session.getSession().setAttribute("perso1", perso1);
    		session.getSession().setAttribute("perso2", perso2);
    		session.getSession().setAttribute("perso3", perso3);
    		session.getSession().setAttribute("perso4", perso4);
    		session.getSession().setAttribute("perso5", perso5);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    }
	
}
