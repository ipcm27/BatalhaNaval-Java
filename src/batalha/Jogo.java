package batalha;

public class Jogo {

    public static void main(String[] args) {

        Tabuleiro tabUser = new Tabuleiro();
        Tabuleiro tabComputer = new Tabuleiro();

        Usuario user = new Usuario(tabUser);
        Computador computer = new Computador(tabComputer);

        user.posicionarNavios();
        computer.posicionarNaviosComputador(user, computer);

        jogar(user, computer);

        tabUser.showMatrix();
        tabComputer.showMatrixComputador();

    }

    private static void jogar(Usuario user, Computador computer) {
        while (true) {
            user.atacarComputador(computer.tabuleiroComputador);
            computer.atacarUsuario(user.tabuleiroUsuario);
            if (user.getPoints() >= 10) {
                System.out.printf("Você venceu!");
                break;
            } else if (computer.getPoints() >= 10) {
                System.out.printf("Você perdeu!");
                break;
            }
        }
    }

}
