package batalha;

public class Jogo {
    public static void main(String[] args) {
        Tabuleiro compTab = new Tabuleiro();
        Computador comp = new Computador(compTab);

        System.out.println(comp.getRandomNumber());
        System.out.println(comp.getRandomNumber());
        System.out.println(comp.getRandomNumber());

    }
}
