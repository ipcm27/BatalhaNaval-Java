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
    private Boolean compararPosicaoComUsuarioEcomputador(int row,int col,Tabuleiro tabuleiro){
        String rowColInseridos  = tabuleiro.getStringMatrix(row,col);
        return (rowColInseridos.equalsIgnoreCase("| n ") || rowColInseridos.equalsIgnoreCase("| n |"));
    }

    //FUNÇÃO VERIFICA SE COMPUTADOR ATIROU NELE MESMO
    private Boolean shootYourselfComputer(int row,int col){
        String rowColInseridos  = tabuleiroComputador.getStringMatrix(row,col);
        return (rowColInseridos.equals("| N ") || rowColInseridos.equalsIgnoreCase("| N |"));
    }

    //FUNÇÃO VALIDA ACERTO
    private Boolean shootRight(int row,int col,Tabuleiro tabUser){
        String rowColInseridos  = tabUser.getStringMatrix(row,col);
        return (rowColInseridos.equals("| n ") || rowColInseridos.equalsIgnoreCase("| n |"));
    }

    //FUNÇÃO PARA NÃO REPETIR TIRO CERTO
    private Boolean notRepeatShootRight(int row,int col){
        String rowColInseridos  = tabuleiroComputador.getStringMatrix(row,col);
        return (rowColInseridos.equals("| X ") || rowColInseridos.equalsIgnoreCase("| X |"));
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
            
        }
        tabuleiroComputador.showMatrixComputador();
    }

    // Tentar atirar em coordenadas aleatórias até que o tiro seja válido
    public Boolean shootComputer(Tabuleiro tabUser) {
        boolean isValidPoint = false;
        int row = 0,col = 0;

        while (!isValidPoint) {
            row = getRandomNumber();
            col = getRandomNumber();
            isValidPoint = checkValidPoint(row, col) && tabUser.notRepeatAttack(row,col);
        }

        if(shootRight(row,col,tabUser)){
            tabUser.addShoot(row,col,"X");
            pontuarComputer();
            return true;
        }else{
            tabUser.addShootWater(row,col);
            return false;
        }
    }

    //FUNÇÃO PARA FAZER VALIDAÇÃO DO TIRO COMPUTADOR
    private boolean checkValidPoint(int row, int col) {
        if(shootYourselfComputer(row,col)){
            return false;
        }else if(notRepeatShootRight(row,col)){
            return false;
        }else{
            return true;
        }
    }

    private void pontuarComputer() {
        this.points++;
    }

}
