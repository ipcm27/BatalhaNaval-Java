package batalha;

public class Tabuleiro {
    private final String[][] matrizTabuleiro = new String[12][12];

    public String getStringMatrix(int row,int col){
        return matrizTabuleiro[row][col];
    }
    
	private String alphabetical(int row){
        switch(row){
            case 1: return "A";
            case 2: return "B";
            case 3: return "C";
            case 4: return "D";
            case 5: return "E";
            case 6: return "F";
            case 7: return "G";
            case 8: return "H";
            case 9: return "I";
            case 10: return "J";
            default: return " ";
        }
    }

    //FUNÇÃO ADICIONAR TIRO
    public void addShoot(int row,int col,String shoot){
        matrizTabuleiro[row][col] = (col == 10)? String.format("| X |",shoot):String.format("| X ",shoot);
    }

    //FUNÇÃO ADICIONA TIRO NA ÁGUA
    public void addShootWater(int row,int col){
        matrizTabuleiro[row][col] = (col == 10)? "| - |":"| - ";
    }

    //FUNÇÃO EVITA TIROS REPETIDOS NA ÁGUA RETORNANDO FALSE
    public Boolean notRepeatAttack(int row, int col){
        String rowColInseridos = this.getStringMatrix(row,col);
        return !(rowColInseridos.equals("| - ") || rowColInseridos.equals("| - |"));
    }

    //FUNÇÃO PARA NÃO REPETIR TIRO CERTO
    private Boolean notRepeatShootRight(int row,int col){
        String rowColInseridos  = this.getStringMatrix(row,col);
        return (rowColInseridos.equalsIgnoreCase("| X ") || rowColInseridos.equalsIgnoreCase("| X |"));
    }

    //FUNÇÃO PARA INICIAR MATRIZ
    public void startMatrix(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(j == 0){
                    matrizTabuleiro[i][j] = String.format("| %s ", alphabetical(i));
                }else if(i == 0){
                    matrizTabuleiro[i][j] = String.format("| %d ",j-1);
                }else{
                    matrizTabuleiro[i][j] = "|   ";
                }
            }
            matrizTabuleiro[i][10] += "|";
        }
    }

    //FUNÇÃO PARA MOSTRAR MATRIZ
    public void showMatrix(){
        System.out.printf("---------------------------------------------%n");
        System.out.printf("                   JOGADOR                   %n");
        System.out.printf("---------------------------------------------%n");
        for(int i = 0; i < 11;i++){
            for(int j = 0; j < 11;j++){
                if(j == 10){
                    System.out.printf(matrizTabuleiro[i][j]+"%n");
                }else{
                    System.out.print(matrizTabuleiro[i][j]);
                }
            }
            System.out.printf("---------------------------------------------%n");
        }
    }
    
    public void showMatrixComputador(){
        System.out.printf("---------------------------------------------%n");
        System.out.printf("                  COMPUTADOR                 %n");
        System.out.printf("---------------------------------------------%n");
        for(int i = 0; i < 11;i++){
            for(int j = 0; j < 11;j++){
                if(j == 10){
                    System.out.printf(matrizTabuleiro[i][j]+"%n");
                }else{
                    System.out.print(matrizTabuleiro[i][j]);
                }
            }
            System.out.printf("---------------------------------------------%n");
        }
    }

    //FUNÇÃO ADICIONAR NAVIO
    public void addShipMatrixUser(int row,int col){
        matrizTabuleiro[row][col] = (col == 10)? "| n |":"| n ";
    }

    public void addShipMatrixComputer(int row,int col){
        matrizTabuleiro[row][col] = (col == 10)? "| N |":"| N ";
    }

}
