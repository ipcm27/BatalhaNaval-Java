package batalha;

public class Jogo {


    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();

        tab.startMatrix();
        tab.showMatrix();
        tab.addShipMatrix(1,3);
        tab.showMatrix();
    }
}
