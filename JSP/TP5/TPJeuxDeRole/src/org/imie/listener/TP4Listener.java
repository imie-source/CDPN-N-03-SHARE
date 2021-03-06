package org.imie.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.imie.model.Personnage;

/**
 * Application Lifecycle Listener implementation class TP4Listener
 *
 */
@WebListener
public class TP4Listener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public TP4Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         HttpSession httpSession = arg0.getSession();
         List<Personnage> personnages = new ArrayList<Personnage>();
         
         Personnage perso1 = new Personnage();
         perso1.setNom("perceval");
         perso1.setExp(new Double(100));
         perso1.setHp(new Double(1000));
         perso1.setDateCreation(new Date());
         personnages.add(perso1);
         
         Personnage perso2 = new Personnage();
         perso2.setNom("lancelot");
         perso2.setExp(new Double(200));
         perso2.setHp(new Double(1000));
         perso2.setDateCreation(new Date());
         personnages.add(perso2);
         
         Personnage perso3 = new Personnage();
         perso3.setNom("arthur");
         perso3.setExp(new Double(500));
         perso3.setHp(new Double(1000));
         perso3.setDateCreation(new Date());
         personnages.add(perso3);
         
         Personnage perso4 = new Personnage();
         perso4.setNom("karadock");
         perso4.setExp(new Double(80));
         perso4.setHp(new Double(1000));
         perso4.setDateCreation(new Date());
         personnages.add(perso4);
         
         httpSession.setAttribute("personnages", personnages);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
