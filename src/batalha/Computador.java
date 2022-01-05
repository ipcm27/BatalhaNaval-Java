package batalha;

import java.util.List;
import java.util.Random;

public class Computador {

    public Tabuleiro tab;
    private int points = 0;

    public Computador(Tabuleiro tab) {
        this.tab = tab;
        tab.startMatrix();
        //tab.showMatrix(); Por enquanto sem mostrar
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(11 - 1) + 1;
    }

    //FUNÇÃO RESPONSAVEL POR VALIDA POSIÇÕES DO COMPUTADOR
    public Boolean validPositionShipComputer(int row,int col,Tabuleiro tab){
        String valid = tab.getStringMatrix(row,col);
        return (valid.equalsIgnoreCase("| n ") || valid.equalsIgnoreCase("| n |"));
    }

    //FUNÇÃO GERA OS NAVIES INICIAIS PARA COMEÇA
    public void generatorPositionShips(Usuario u,Tabuleiro t){
        int numberShips = 0;
        int row = getRandomNumber();
        int col = getRandomNumber();

        while(validPositionShipComputer(row,col,u.userTab) && numberShips < 3){
            t.addShipMatrixComputer(row,col);
            numberShips++;
        }
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
