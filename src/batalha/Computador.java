package batalha;

import java.util.List;
import java.util.Random;

public class Computador {

    public Tabuleiro tab;
    private int points = 0;

    public Computador(Tabuleiro tab) {
        this.tab = tab;
        tab.startMatrix();
        tab.showMatrix();
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(11 - 1) + 1;
    }

    private int getPointId(int row, int col) {
        return row * 10 + col;
    }

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
