

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import metier.Personnage;

/**
 * Application Lifecycle Listener implementation class sessionListenner
 *
 */
@WebListener
public class sessionListenner implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public sessionListenner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent session)  { 
    	Date now= new Date();
		
		Personnage perso1 = new Personnage("Kafy", now);
		Personnage perso2 = new Personnage("Croquelune", now);
		Personnage perso3 = new Personnage("Wolfood", now);
		Personnage perso4 = new Personnage("Cristale", now);
		
		perso1.setExp(5000l);
		perso2.setExp(300l);
		perso3.setExp(800l);
		perso4.setExp(100l);
		
		List<Personnage> listePersonnages = new ArrayList<Personnage>() ;

		listePersonnages.add(perso1);
		listePersonnages.add(perso2);
		listePersonnages.add(perso3);
		listePersonnages.add(perso4);

		session.getSession().setAttribute("listePersonnages", listePersonnages);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
