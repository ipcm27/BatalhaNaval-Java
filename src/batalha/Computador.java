package batalha;

import java.util.Random;

public class Computador {

    public Tabuleiro tabuleiroComputador;
    private int points = 0;
    private static String RED_COMP = "\u001B[31m";
    private static String RESET_COMP = "\u001B[0m";
    public static String shootComputer = RED_COMP+"\u274E"+ RESET_COMP;

    public int getPoints() {
        return points;
    }

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
    private Boolean compararPosicaoComUsuarioEcomputador(int row,int col,Tabuleiro tabuleiro){
        String rowColInseridos  = tabuleiro.getStringMatrix(row,col);
        return (rowColInseridos.equalsIgnoreCase(
                String.format("| %s ", Tabuleiro.NAVIO_USUARIO)) || rowColInseridos.equalsIgnoreCase(
                        String.format("| %s |",Tabuleiro.NAVIO_USUARIO)));
    }

    //FUNÇÃO VERIFICA SE COMPUTADOR ATIROU NELE MESMO
    private Boolean shootYourselfComputer(int row,int col){
        String rowColInseridos  = tabuleiroComputador.getStringMatrix(row,col);
        return (rowColInseridos.equals(
                String.format("| %s ", Tabuleiro.NAVIO_COMPUTADOR)) || rowColInseridos.equalsIgnoreCase(
                        String.format("| %s |", Tabuleiro.NAVIO_COMPUTADOR)));
    }

    //FUNÇÃO GERA OS NAVIES INICIAIS PARA COMEÇA
    public void posicionarNaviosComputador(Usuario usuario,Computador computador){
    	
    	int i = 1;

        while(i < 11){
        	 int row = getRandomNumber();
             int col = getRandomNumber();
             
             if (!compararPosicaoComUsuarioEcomputador(row,col, usuario.tabuleiroUsuario)) {
            	 tabuleiroComputador.addShipMatrixComputer(row,col);
            	 i++;
             }
            
        }
        //tabuleiroComputador.showMatrixComputador();
    }

    // Tentar atirar em coordenadas aleatórias até que o tiro seja válido
    public Boolean atacarUsuario(Tabuleiro tabUser) {
        boolean isValidPoint = false;
        int row = 0,col = 0;

        while (!isValidPoint) {
            row = getRandomNumber();
            col = getRandomNumber();
            isValidPoint = checkValidPoint(row, col) && tabUser.notRepeatAttack(row,col);
        }

        boolean acertou = tabUser.shoot(row, col);

        // O acerto OU tiro na água também é marcado no tabuleiro do usuário
        if (acertou) {
            tabuleiroComputador.addShoot(row, col,shootComputer);
            pontuarComputer();
            tabUser.showMatrix();
            System.out.printf(String.format(RED_COMP+"O computador acertou! Você ainda tem %s navios%n"+RESET_COMP, 10 - points));
        } else {
            tabuleiroComputador.addShootWater(row, col);
            tabUser.showMatrix();//quando computador erra mostra na tela onde computador atirou
            System.out.printf(RED_COMP+"O computador errou.%n"+RESET_COMP);
        }

        return acertou;
    }

    //FUNÇÃO PARA FAZER VALIDAÇÃO DO TIRO COMPUTADOR
    private boolean checkValidPoint(int row, int col) {
        if(shootYourselfComputer(row,col)){
            return false;
        }else if(this.tabuleiroComputador.notRepeatAttackAdversary(row,col)) {
            return false;
        }else{
            return true;
        }
    }

    private void pontuarComputer() {
        this.points++;
    }

}
