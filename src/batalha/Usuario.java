package batalha;

import java.util.Scanner;

public class Usuario {
	
	

	public static int points;
	public Tabuleiro tabuleiroUsuario;
	
	public static int getPoints() {
		return points;
	}
	
	public Usuario(Tabuleiro userTab) {
		
		this.tabuleiroUsuario = userTab;
		//estou inicializando a matriz dentro do construtor usuário
		userTab.startMatrix();
		userTab.showMatrix();
	}


	//FUNÇÃO MUDA LETRA POR NÚMERO
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

	//ESSA FUNÇÃO EVITA QUE USUARIO REPITA MESMO LANCE
	public Boolean compararPosicaoUsuarioNaoRepetida(int row,int col,Tabuleiro tabuleiro){
		String rowColInseridos  = tabuleiro.getStringMatrix(row,col);
		return (rowColInseridos.equals("| n ") || rowColInseridos.equals("| n |"));
	}

	//FUNÇÃO VERIFICA SE USARIO DIGITOU VALOR ENTRE 1 E 10
	public Boolean validatePosition(int cord){
		return (cord > 0 && cord < 11);
	}
	

	public int inserirLinha() {
		Scanner scan = new Scanner(System.in);
		boolean isValid = false;
		int rowInt = 0;
		
		while(isValid == false) {
		System.out.println("Insira a linha entre A e J");
		String row = scan.next();
		rowInt = changeAlpha(row);
		isValid = validatePosition(rowInt);
		
		}
		return rowInt;
	}
	
	public int inserirColuna() {
		Scanner scan = new Scanner(System.in);
		boolean isValid = false;
		int column =0;
		
		
		while(isValid == false) {
		
		System.out.println("Insira a Coluna");
		column = scan.nextInt() + 1;
		isValid = validatePosition(column);
		}
		
		return column;
	}
		

	
	public void posicionarNavios() {
		int i = 1;
		tabuleiroUsuario.startMatrix();
		
		System.out.println("Insira a linha e a coluna que deseja colocar seus navios");
		while(i < 11) {
		
			System.out.println("Adicione o " + i + " Navio");
			int LINHA = inserirLinha();
			int COLUNA = inserirColuna();
			
			if(!compararPosicaoUsuarioNaoRepetida(LINHA,COLUNA,tabuleiroUsuario)){
				tabuleiroUsuario.addShipMatrixUser(LINHA, COLUNA);
				tabuleiroUsuario.showMatrix(); //ACHEI QUE FICA MELHOR MOSTRANDO CADA INSERÇÃO
				i++;
			}

		};

	}
	
	
	public void pontuar () {
		this.points++;
	}
	
	public void jogarBombaNoComputador() {
		System.out.println("Insira a linha e a coluna para jogar a BOMBA");
		int LINHA = inserirLinha();
		int COLUNA = inserirColuna();
		
	}
	
	
	
}
