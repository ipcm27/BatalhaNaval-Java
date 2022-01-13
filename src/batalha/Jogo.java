package batalha;

public class Jogo {
	
	 public static void imprimirInstruções() {
	    	String instruções= "\n INSTRUÇÕES \n Navio do Usuario = n \n Navio do Computador = N \n Navio Atingido do usuario =X \n Navio Atingido do computador = * \n Tiros na agua (computador e usuario) = - \n ";
	    	System.out.println(instruções);
	    }

    public static void main(String[] args) {

        Tabuleiro tabUser = new Tabuleiro();
        Tabuleiro tabComputer = new Tabuleiro();

        Usuario user = new Usuario(tabUser);
        Computador computer = new Computador(tabComputer);

        user.posicionarNavios();
        computer.posicionarNaviosComputador(user, computer);

        jogar(user, computer);

        tabUser.showMatrix();
        //tabComputer.showMatrixComputador();

    }

    private static void jogar(Usuario user, Computador computer) {
        int rodada = 1;
        boolean isJogadaCorreta = true;
        imprimirInstruções();

        while (true) {
        	
        	 
        	user.atacarComputador(computer.tabuleiroComputador, user);
            setTimeout(computer, user.tabuleiroUsuario,2500);

            //computer.atacarUsuario(user.tabuleiroUsuario);
            
            // O settimeout tava deixando o jogo ruim pra testar

            

            rodada++;
            System.out.printf(String.format("%n------------------ RODADA %s ------------------%n", rodada));

            if (user.getPoints() == 10) {

                System.out.printf("Você venceu!");
                user.parabensVoceGanhou();
                
                break;
            } else if (computer.getPoints() == 10) {
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
