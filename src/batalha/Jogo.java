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
        int rodada = 1;

        while (true) {
            user.atacarComputador(computer.tabuleiroComputador);
<<<<<<< HEAD
            computer.atacarUsuario(user.tabuleiroUsuario);
            if (user.getPoints() == 2) {
            	user.parabensVoceGanhou();
=======
            //computer.atacarUsuario(user.tabuleiroUsuario);
            setTimeout(computer, user.tabuleiroUsuario,3000);

            rodada++;
            System.out.printf(String.format("%n------------------ RODADA %s ------------------%n", rodada));

            if (user.getPoints() >= 10) {
>>>>>>> e1ff7400648baf282dfe900d34fc2b567255137e
                System.out.printf("Você venceu!");
                break;
            } else if (computer.getPoints() == 2) {
                System.out.printf("Você perdeu!");
                break;
            }
        }
    }

    public static void setTimeout(Computador computador,Tabuleiro tab,int time){
        try {
            Thread.sleep(time);
            computador.atacarUsuario(tab);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
