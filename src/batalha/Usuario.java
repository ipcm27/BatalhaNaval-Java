package batalha;


import java.util.Scanner;

public class Usuario {
	
	

	public static int points = 0;
	public Tabuleiro tabuleiroUsuario;
	private static final String RESET_USE = "\u001B[0m";
	private static final String GREEN_USE = "\u001B[32m";
	public static String shootUse = GREEN_USE+"\u2714"+RESET_USE;
	
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
		return (rowColInseridos.equals(
				String.format("| %s "+Tabuleiro.RESET,Tabuleiro.NAVIO_USUARIO )) || rowColInseridos.equals(
				String.format("| %s |"+Tabuleiro.RESET,Tabuleiro.NAVIO_USUARIO)));
	}


	//FUNÇÃO VERIFICA SE USARIO DIGITOU VALOR ENTRE 1 E 10
	public Boolean validatePosition(int cord){
		return (cord > 0 && cord < 11);
	}
	
		
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
		System.out.println(GREEN_USE+"Insira a posição (entre A0 e J9):"+RESET_USE);
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	
	public void posicionarNavios() {
		int i = 1;
		tabuleiroUsuario.startMatrix();
		
		System.out.println(GREEN_USE+"Insira a linha e a coluna que deseja colocar seus navios"+RESET_USE);
		while(i < 3) {

			System.out.println(GREEN_USE+"Adicione o " + i + " Navio"+RESET_USE);
			String input = readCoordinates();

			int[] coordenadas;
			try {
				coordenadas = parseCoordinates(input);
			} catch (Exception e) {
				System.out.println(GREEN_USE+"Posição inválida!"+RESET_USE);
				continue;
			}
			int LINHA = coordenadas[0];
			int COLUNA = coordenadas[1];
			
			if(!compararPosicaoUsuarioNaoRepetida(LINHA,COLUNA,tabuleiroUsuario)){
				tabuleiroUsuario.addShipMatrixUser(LINHA, COLUNA);
				tabuleiroUsuario.showMatrix(); //ACHEI QUE FICA MELHOR MOSTRANDO CADA INSERÇÃO
				i++;
			}else{
				System.out.println(GREEN_USE+"POSIÇÃO REPETIDA DIGITE NOVAMENTE"+RESET_USE);
			}

		};

	}
	
	
	private void pontuarUser() {
		this.points++;
	}
	
	public boolean atacarComputador(Tabuleiro tabComputador, Usuario usuario) {
		System.out.println(GREEN_USE+"Insira a linha e a coluna para jogar a BOMBA"+RESET_USE);

		// Receber linha e coluna a ser atacada
		String input = readCoordinates();
		int[] coordenadas;
		try {
			coordenadas = parseCoordinates(input);
		} catch (Exception e) {
			System.out.println(GREEN_USE+"Posição inválida!"+RESET_USE);
			return false;
		}
		int row = coordenadas[0];
		int col = coordenadas[1];

		// Verificar se usuário já atirou ali
		boolean jaAtirouAli = !tabComputador.notRepeatAttack(row, col);
		boolean jaAcertouNavio = !tabComputador.notRepeatShootRight(row, col);
		boolean isProprioNavio = usuario.compararPosicaoUsuarioNaoRepetida(row, col, usuario.tabuleiroUsuario);

		boolean nãoEhtiroValido = !(jaAtirouAli || jaAcertouNavio || isProprioNavio);
		
		if (isProprioNavio) {System.out.printf(GREEN_USE+"Você não pode atirar no seu próprio navio - perdeu a vez \n"+RESET_USE);}
		if (nãoEhtiroValido) {System.out.printf(GREEN_USE+"Você já atirou nessa posição!"+RESET_USE);}
		
		// Retornar se o tiro foi válido ou não
		if (nãoEhtiroValido || isProprioNavio ) {
			
			return false;
		} else {
			// Verificar se o tiro acertou um navio
			boolean acertou = tabComputador.shoot(row, col);

			// O acerto OU tiro na água também é marcado no tabuleiro do computador
			if (acertou) {
				tabuleiroUsuario.addShoot(row, col,shootUse);//Usuario acertou adicionar *
				pontuarUser();
//				tabComputador.showMatrixComputador();
				tabuleiroUsuario.showMatrix();
				System.out.printf(String.format(GREEN_USE+"Você acertou um navio!! Faltam %s%n"+RESET_USE, 10 - points));
			} else {
				tabuleiroUsuario.addShootWater(row, col);
//				tabComputador.showMatrixComputador();
				tabuleiroUsuario.showMatrix();
				System.out.printf(GREEN_USE+"Você errou.%n"+RESET_USE);
			}
			return acertou;
		}
	}

	public void parabensVoceGanhou() {
		System.out.println(GREEN_USE+"     ___"+RESET_USE);
		System.out.println(GREEN_USE+"    \\_/"+RESET_USE);
		System.out.println(GREEN_USE+"      |._"+RESET_USE);
		System.out.println(GREEN_USE+"      |'.\"-._.-\"\"--.-\"-.__.-'/"+RESET_USE);
		System.out.println(GREEN_USE+"      |  \\       .-.        ("+RESET_USE);
		System.out.println(GREEN_USE+"      |   |     (@.@)        )"+RESET_USE);
		System.out.println(GREEN_USE+"      |   |   '=.|m|.='     /"+RESET_USE);
		System.out.println(GREEN_USE+" BIK  |  /    .='`\"``=.    /"+RESET_USE);
		System.out.println(GREEN_USE+"      |.'                 ("+RESET_USE);
		System.out.println(GREEN_USE+"      |.-\"-.__.-\"\"-.__.-\"-.)"+RESET_USE);
		System.out.println(GREEN_USE+"      |"+RESET_USE);
		System.out.println(GREEN_USE+"      |"+RESET_USE);
		System.out.println(GREEN_USE+"      | "+RESET_USE);
		System.out.println(GREEN_USE+"        "+RESET_USE);
		System.out.println(GREEN_USE+"-=[ Parabéns, você é um pirata de verdade ]=-   "+RESET_USE);
	}	
}
