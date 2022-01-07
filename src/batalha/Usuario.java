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
	private int changeAlpha(String row) {
		char rowChar = row.toUpperCase().charAt(0); // Pega o primeiro caractere
		int ascii = rowChar; // Converte para código ASCII
		return ascii - 64;
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
	

	// @Igor: fiz uma alteração no input para ler linha e coluna de uma vez só,
	// então não estamos mais usando esses métodos! Pode apagar se quiser :)
	/*
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
	} */
		
	private int[] parseCoordinates(String input) {
		// Converte as coordenadas inseridas para um array de inteiros

		// Verificar se o tamanho da string é 2
		if (input.length() != 2) {
			throw new IllegalArgumentException();
		}

		// Converter para caracteres
		char row = input.toUpperCase().charAt(0);
		char col = input.charAt(1);

		// Verificar se são uma letra e um número
		boolean isRowValid = Character.isLetter(row);
		boolean isColValid = Character.isDigit(col);
		if (!(isRowValid && isColValid)) {
			throw new IllegalArgumentException();
		}

		// Converter para número
		int rowNum = Utils.letterToRow(row) + 1;
		int colNum = Integer.parseInt(Character.toString(col)) + 1;

		// Verificar se está entre 0 e 11
		if (!(validatePosition(rowNum) && validatePosition(rowNum))) {
			throw new IllegalArgumentException();
		}

		// Retornar como array
		return new int[] {rowNum, colNum};
	}

	private String readCoordinates() {
		System.out.println("Insira a posição (entre A0 e J9):");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	
	public void posicionarNavios() {
		int i = 1;
		tabuleiroUsuario.startMatrix();
		
		System.out.println("Insira a linha e a coluna que deseja colocar seus navios");
		while(i < 3) {

			System.out.println("Adicione o " + i + " Navio");
			String input = readCoordinates();

			int[] coordenadas;
			try {
				coordenadas = parseCoordinates(input);
			} catch (Exception e) {
				System.out.println("Posição inválida!");
				continue;
			}
			int LINHA = coordenadas[0];
			int COLUNA = coordenadas[1];
			
			if(!compararPosicaoUsuarioNaoRepetida(LINHA,COLUNA,tabuleiroUsuario)){
				tabuleiroUsuario.addShipMatrixUser(LINHA, COLUNA);
				tabuleiroUsuario.showMatrix(); //ACHEI QUE FICA MELHOR MOSTRANDO CADA INSERÇÃO
				i++;
			}else{
				System.out.println("POSIÇÃO REPETIDA DIGITE NOVAMENTE");
			}

		};

	}
	
	
	private void pontuarUser () {
		this.points++;
	}
	
	public boolean atacarComputador(Tabuleiro tabComputador) {
		System.out.println("Insira a linha e a coluna para jogar a BOMBA");

		// Receber linha e coluna a ser atacada
		String input = readCoordinates();
		int[] coordenadas;
		try {
			coordenadas = parseCoordinates(input);
		} catch (Exception e) {
			System.out.println("Posição inválida!");
			return false;
		}
		int row = coordenadas[0];
		int col = coordenadas[1];

		// Verificar se usuário já atirou ali
		boolean jaAtirouAli = !tabComputador.notRepeatAttack(row, col);
		boolean jaAcertouNavio = !tabComputador.notRepeatShootRight(row, col);

		// Retornar se o tiro foi válido ou não
		boolean tiroValido = !(jaAtirouAli || jaAcertouNavio);
		if (!(tiroValido)) {
			System.out.printf("Você já atirou nessa posição!");
			return false;
		} else {
			// Verificar se o tiro acertou um navio
			boolean acertou = tabComputador.shoot(row, col);

			// O acerto OU tiro na água também é marcado no tabuleiro do computador
			if (acertou) {
				tabComputador.addShoot(row, col,"X");
				pontuarUser();
			} else {
				tabComputador.addShootWater(row, col);
			}
			return acertou;
		}
	}
	
	
	
}
