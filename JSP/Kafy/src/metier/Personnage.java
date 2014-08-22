package metier;
import java.util.Date;
import java.util.UUID;

public class Personnage {
	private String id;
	private String nom;
	private Date dateCreation;
	private Long exp;
	private Long vie;
	private String urlImage;
	private Plateau plateau;
	private int x;
	private int y;
	
	public Personnage() {
	}
	
	public Personnage(String nom, Date dateCreation) {
		this.id= ""+UUID.randomUUID();
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.exp = new Long(0);
		this.vie = new Long(100);
		this.urlImage="";
		this.plateau=new Plateau();
		this.x=1;
		this.y=4;
		this.plateau.addElement(x, y, 1);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getExp() {
		return exp;
	}

	public void setExp(Long exp) {
		this.exp = exp;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getVie() {
		return vie;
	}

	public void setVie(Long vie) {
		this.vie = vie;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Integer getNiveau(){
		
		Long exp = this.exp;
		int expNextLvl=100;
		Integer niveau=0;
		
		while(exp>=0){
			niveau++;
			exp-=expNextLvl;
			expNextLvl+=(expNextLvl/2);
		}
		
		return niveau;
	}
	
	public void addExp(int ajout) {
		this.exp += ajout;
	}
	
}
