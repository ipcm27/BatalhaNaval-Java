package batalha;

import java.util.Scanner;

public class Usuario {
	
	

	public static int points;
	public Tabuleiro userTab;
	
	public static int getPoints() {
		return points;
	}
	
	public Usuario(Tabuleiro userTab, int points) {
		this.points = points;
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

	//FUNÇÃO VERIFICA SE USARIO DIGITOU VALOR ENTRE 1 E 10
	public Boolean validPositionShip(int cord){
		return cord > 0 && cord < 11;
	}
	
	public void posicionarNavios() {
		Scanner scan = new Scanner(System.in);
		userTab.startMatrix();
		
		System.out.println("Insira a linha e a coluna que deseja colocar seus navios");
		for (int i = 1; i < 3;i++) {
			System.out.println("Adicione o " + i + " Navio");
			
			boolean valido = false;
			String row;
			
			System.out.println("Insira a linha entre A e J");
			row = scan.next();
			int rowInt = changeAlpha(row);
			
			
			if (validPositionShip(rowInt) == false) {
				while (valido == false) {
				System.out.println("essa letra não é válida");	
				System.out.println("Insira a linha entre A e J");
				row = scan.next();
				rowInt = changeAlpha(row);
				valido = validPositionShip(rowInt);
				}
			};
			
			
			System.out.println("Insira a Coluna");
			int column = scan.nextInt();
			validPositionShip(column);
			
			userTab.addShipMatrix(rowInt, column);
		};
		userTab.showMatrix();
	}
	
	public void pontuar () {
		this.points++;
	}
	
	
}
