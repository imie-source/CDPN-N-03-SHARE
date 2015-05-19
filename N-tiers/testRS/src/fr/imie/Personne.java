/**
 * 
 */
package fr.imie;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
