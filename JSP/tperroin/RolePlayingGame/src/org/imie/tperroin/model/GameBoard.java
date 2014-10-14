package org.imie.tperroin.model;

import java.util.ArrayList;

public class GameBoard {
	
	private ArrayList<Cell> cells;
	
	public GameBoard() {
		super();
	}

	public void setCells(ArrayList<Cell> cells) {
		for (int i = 0; i < 100; i++) {
			cells.add(new Cell(i));
		}
		this.cells = cells;
	}

	public ArrayList<Cell> getCells() {		
		return cells;
	}
	
	public Cell applyCell(Long num) {
		Integer i = (int) (long) num;
		Cell cell = getCells().get(i);
		return cell;
	}
	
	public ArrayList<Integer> getXs() {
		
		ArrayList<Integer> xs = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			xs.add(i * 10);
		}
		
		return xs;
	}
	
	public ArrayList<Integer> getYs() {
		
		ArrayList<Integer> ys = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			ys.add(i);
		}
		
		return ys;
	}

}
