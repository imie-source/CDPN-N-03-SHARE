/**
 * 
 */
package fr.imie;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;

/**
 * @author imie
 *
 */
public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1771900215963773743L;
	private Integer id;
	private String nom;
	private Date dateNaissance;
	private List<Livre> livres;

	public Personne() {
		super();
		livres = new ArrayList<Livre>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateNaissance() {
		String retour = null;
		if (dateNaissance != null) {
			retour = new SimpleDateFormat("dd/MM/yyyy").format(dateNaissance);
		}

		return retour;
	}

	public void setDateNaissance(String dateNaissance) {
		if (dateNaissance != null) {
			try {
				this.dateNaissance = new SimpleDateFormat("dd/MM/yyyy")
						.parse(dateNaissance);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addLivre(Livre livre) {
		livres.add(livre);
	}

	public void deleteLivre(Livre livre) {
		livres.remove(livre);
	}

	public Link selfLinks() {
		Link retour = null;
		try {
			UriBuilder uriSelf = UriBuilder.fromResource(ServiceRestPersonne.class);
			Class[] argsSelf = { Integer.class };
			uriSelf = uriSelf.path(ServiceRestPersonne.class.getMethod("getOne",
					argsSelf));
			retour= Link.fromUriBuilder(uriSelf).rel("self").build(this.id);

			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}

	public List<Link> getLinks() {
		ArrayList<Link> retour = new ArrayList<Link>();
		retour.add(selfLinks());
		return retour;

	}

}
