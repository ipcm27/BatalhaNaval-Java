package batalha;

import java.util.List;
import java.util.Random;

public class Computador {

    public Tabuleiro tabuleiroComputador;
    private int points = 0;

    public Computador(Tabuleiro tab) {
        this.tabuleiroComputador = tab;
        tab.startMatrix();
        //tab.showMatrix(); Por enquanto sem mostrar
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(11 - 1) + 1;
    }

    //FUNÇÃO RESPONSAVEL POR VALIDA POSIÇÕES DO COMPUTADOR
    public Boolean compararPosicaoComUsuarioEcomputador(int row,int col,Tabuleiro tabuleiro){
        String rowColInseridos  = tabuleiro.getStringMatrix(row,col);
        return (rowColInseridos.equalsIgnoreCase("| n ") || rowColInseridos.equalsIgnoreCase("| n |"));
    }
    
  
    

    //FUNÇÃO GERA OS NAVIES INICIAIS PARA COMEÇA
    public void posicionarNaviosComputador(Usuario usuario,Computador computador){
    	
    	int i = 1;

        while(i < 3){
        	 int row = getRandomNumber();
             int col = getRandomNumber();
             
             if (!compararPosicaoComUsuarioEcomputador(row,col, usuario.tabuleiroUsuario)) {
            	 tabuleiroComputador.addShipMatrixComputer(row,col);
            	 i++;
             }
             tabuleiroComputador.showMatrixComputador();
        }
        
// BERNARDO VÊ SE É UTIL E APAGA
        
//        while(validatePositionComputer(row,col,usuario.userTab) && numberShips < 3){
//            computador.tab.addShipMatrixComputer(row,col);
//            numberShips++;
//        }
    }

//    public void addShips(int navios) {
//        int naviosPosicionados = 0;
//        while (naviosPosicionados < 10) {
//            int row = getRandomNumber();
//            int col = getRandomNumber();
//            if (tab.addShipMatrix(row, col)) {
//                naviosPosicionados++;
//            }
//        }
//    }

    public void shoot() {
        // Tentar atirar em coordenadas aleatórias até que o tiro seja válido
        boolean isValidPoint = false;
        while (!isValidPoint) {
            int row = getRandomNumber();
            int col = getRandomNumber();
            isValidPoint = checkValidPoint(row, col);
        }
    }

    public boolean checkValidPoint(int row, int col) {
        return true; // tab._____(row, col);
        //usar método do tabuleiro
    }

    public void score() {
        this.points++;
    }

}
