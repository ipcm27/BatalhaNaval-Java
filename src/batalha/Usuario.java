package batalha;

import java.util.Scanner;

public class Usuario {
	
	private int points;
	private Tabuleiro userTab;
	

	public int getPoints() {
		return points;
	}

	public Tabuleiro getUserTab() {
		return userTab;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setUserTab(Tabuleiro userTab) {
		this.userTab = userTab;
	}


	
	private int changeAlpha(String row){
        if(row.equalsIgnoreCase("A")){ return 1;}
        else if(row.equalsIgnoreCase("B")){ return 2;}
        else if(row.equalsIgnoreCase("C")){ return 3;}
        else if(row.equalsIgnoreCase("D")){ return 4;}
        else if(row.equalsIgnoreCase("E")){ return 5;}
        else if(row.equalsIgnoreCase("F")){ return 6;}
        else if(row.equalsIgnoreCase("G")){ return 7;}
        else if(row.equalsIgnoreCase("H")){ return 8;}
        else if(row.equalsIgnoreCase("I")){ return 9;}
        else if(row.equalsIgnoreCase("J")){ return 10;}
        else { return 0;}
	}
	
	public void posicionarNavios() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Insira a linha e a coluna que deseja colocar seus navios");
		for (int i =0; i<9;i++) {
			System.out.println("Adicione o " + i + "Navio");
			System.out.println("Insira a linha");
			String row = scan.next();
			int rowInt = changeAlpha(row);
			System.out.println("Insira a linha");
			int column = scan.nextInt();
			// Funcao add to the matrix
		}
	}
}
