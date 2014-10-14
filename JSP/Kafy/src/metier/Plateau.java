package metier;

public class Plateau {
	private Case[][] tabPlateau= new Case[10][10];

	public Plateau() {
		this.tabPlateau = tabPlateau;
		int i,j;
		for(i=0; i<10 ;i++){
			for(j=0; j<10 ;j++){
				addCase( i , j, new Case (0,0));
			}
		}
		for(i=0; i<10 ;i++){
			
			addCase( 0 , i , new Case(10 , 10));
			addCase( i , 0 , new Case(10 , 10));
			addCase( i , 9 , new Case(10 , 10));
			addCase( 9 , i , new Case(10 , 10));
		}
		addSol(1 , 4 , 2);
	}

	public Case[][] getTabPlateau() {
		return tabPlateau;
	}

	public void setTabPlateau(Case[][] tabPlateau) {
		this.tabPlateau = tabPlateau;
	}
	
	public void addCase(int x, int y , Case cell){
		tabPlateau[x][y]= cell;
	}
	
	public void addElement(int x, int y, int idElement){
		tabPlateau[x][y].setIdElement(idElement);
	}
	
	public void addSol(int x, int y, int idSol){
		tabPlateau[x][y].setIdSol(idSol);
	}
}
