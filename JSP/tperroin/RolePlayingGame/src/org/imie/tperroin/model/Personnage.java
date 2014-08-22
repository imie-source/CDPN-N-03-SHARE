package org.imie.tperroin.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Personnage {
	
	private Integer id;
	private String name;
	private Integer hp;
	private LocalDate birthday;
	private String image;
	private Long exp; 
	static Integer numId=0;
	private GameBoard gameBoard;
	private Cell currentCell;
		
	public Personnage() {
		super();
		id=numId++;
		this.name = "";
		this.hp = 100;
		this.exp = new Long(0);
		this.birthday = LocalDate.now();
		this.image = "";
		this.currentCell = new Cell(54);
	}

	public Personnage(Integer id, String name, Integer hp, LocalDate birthday, String image, Long exp, GameBoard gameBoard, Cell currentCell) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.birthday = birthday;
		this.image = image;
		this.exp = exp;
		this.gameBoard = gameBoard;
		this.currentCell = currentCell;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Date getFormatDate() {
		
		Instant instant = birthday.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
				
		return Date.from(instant);
	}

	public Long getExp() {
		return exp;
	}

	public void setExp(Long exp) {
		this.exp = exp;
	}
	
	public Integer getLevel() {
		
		Long xp = this.getExp();
		Integer xpRequiredToGoToTheNextLevel = 100;
		Integer level = 0;
		
		while(xp>=0){
			level++;
			xp-=xpRequiredToGoToTheNextLevel;
			xpRequiredToGoToTheNextLevel+=(xpRequiredToGoToTheNextLevel/2);
		}
		
		return level;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	
	
	
	
}
