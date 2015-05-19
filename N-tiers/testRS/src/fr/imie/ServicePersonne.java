/**
 * 
 */
package fr.imie;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

/**
 * @author imie
 *
 */
@SessionScoped
public class ServicePersonne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -262399950218091463L;

	List<Personne> personnes;

	public ServicePersonne() {
		super();
		init();
	}

	private void init() {
		personnes = new ArrayList<Personne>();

		Personne personne1 = new Personne();
		personne1.setId(1);
		personne1.setNom("jean");

		personne1.setDateNaissance("15/12/2000");

		personnes.add(personne1);

		Personne personne2 = new Personne();
		personne2.setId(2);
		personne2.setNom("jo");

		personne2.setDateNaissance("15/12/2001");
		personnes.add(personne2);

	}

	public List<Personne> getAll() {
		return personnes;
	}

	public Personne getById(Integer id) {
		Personne retour = null;
		for (Personne personne : personnes) {
			if (id.equals(personne.getId())) {
				retour = personne;
			}
		}
		return retour;
	}

	public Personne create(Personne personne) {
		personnes.add(personne);
		return personne;
	}

}
