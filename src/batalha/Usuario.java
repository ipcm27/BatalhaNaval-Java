package batalha;

import java.util.Scanner;

public class Usuario {
	
	public static int points;
	public Tabuleiro userTab;
	
	public static int getPoints() {
		return points;
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
		for (int i = 1; i<11;i++) {
			System.out.println("Adicione o " + i + " Navio");
			System.out.println("Insira a linha entre 1 e 10");
			String row = scan.next();
			int rowInt = changeAlpha(row);
			System.out.println("Insira a linha");
			int column = scan.nextInt();
			// Funcao add to the matrix
		
		};
	}
	
	public void pontuar (int points) {
		this.points = points++;
	}
	
	
}
