package org.imie.model;

public class Arme {

	public String Name;
	public String addrImg;
	
	public Arme(String name, String addrImg) {
		super();
		Name = name;
		this.addrImg = addrImg;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddrImg() {
		return addrImg;
	}

	public void setAddrImg(String addrImg) {
		this.addrImg = addrImg;
	}
	
	
	
}
