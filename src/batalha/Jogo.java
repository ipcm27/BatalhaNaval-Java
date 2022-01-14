package batalha;

public class Jogo {
    static final String GREEN = "\u001B[32m";
    static final String RED =  "\u001B[31m";
    private static final String RESET = "\u001B[0m";


    public static void imprimirInstruções() {
	    	String instruções= "\n INSTRUÇÕES \n Navio do Usuario = %s " +
                    "\n Navio do Computador = %s " +
                    "\n Navio Atingido do usuario = %s " +
                    "\n Navio Atingido do computador = %s " +
                    "\n Tiros na agua (computador e usuario) = %s \n ";
	    	System.out.println(String.format(instruções,Tabuleiro.NAVIO_USUARIO,
                    Tabuleiro.NAVIO_COMPUTADOR,Computador.shootComputer,
                    Usuario.shootUse,Tabuleiro.WATER));
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

            computer.atacarUsuario(user.tabuleiroUsuario);
            
            // O settimeout tava deixando o jogo ruim pra testar
            // setTimeout(computer, user.tabuleiroUsuario,2500);
            

            rodada++;
            System.out.printf(String.format("%n------------------ RODADA %s ------------------%n", rodada));

            if (user.getPoints() == 10) {

                System.out.printf(GREEN+"Você venceu!"+RESET);
                user.parabensVoceGanhou();
                
                break;
            } else if (computer.getPoints() == 10) {
                System.out.printf(RED+"Você perdeu!"+RESET);
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
