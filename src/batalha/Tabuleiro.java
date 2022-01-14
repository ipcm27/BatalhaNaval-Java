package batalha;

public class Tabuleiro {
    private final String[][] matrizTabuleiro = new String[12][12];
    private static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED =  "\u001B[31m";
    public static final String WATER = "-";
    public static final String NAVIO_USUARIO = GREEN+"\u26f5"+RESET;
    public static final String NAVIO_COMPUTADOR = RED+"\u26f5"+RESET;


    public String getStringMatrix(int row,int col){
        return matrizTabuleiro[row][col];
    }
    
	private String alphabetical(int row){
        switch(row){
            case 1: return YELLOW+"A"+RESET;
            case 2: return YELLOW+"B"+RESET;
            case 3: return YELLOW+"C"+RESET;
            case 4: return YELLOW+"D"+RESET;
            case 5: return YELLOW+"E"+RESET;
            case 6: return YELLOW+"F"+RESET;
            case 7: return YELLOW+"G"+RESET;
            case 8: return YELLOW+"H"+RESET;
            case 9: return YELLOW+"I"+RESET;
            case 10: return YELLOW+"J"+RESET;
            default: return " ";
        }
    }

    public Boolean notRepeatAttackAdversary(int row,int col){
        String rowColInseridos = this.getStringMatrix(row,col);
        return (notRepeatShootRight(row,col) || (rowColInseridos.equals(
                String.format("| %s "+RESET,Usuario.shootUse)) || rowColInseridos.equals(
                        String.format("| %s |"+RESET, Usuario.shootUse))));
    }

    //FUNÇÃO ADICIONAR TIRO
    public void addShoot(int row,int col,String shoot){
        matrizTabuleiro[row][col] = (col == 10)? String.format("| %s |",shoot):String.format("| %s ",shoot);
    }

    //FUNÇÃO ADICIONA TIRO NA ÁGUA
    public void addShootWater(int row,int col){
        String text = (col == 10)? String.format("| %s |", WATER): String.format("| %s ", WATER);
        matrizTabuleiro[row][col] = text;
    }

    //FUNÇÃO VALIDA ACERTO
    public Boolean shoot(int row, int col) {
        String rowColInseridos = this.getStringMatrix(row, col);

        // Navio do usuário
        if (rowColInseridos.equals(String.format("| %s "+RESET, NAVIO_USUARIO)) || rowColInseridos.equals(
                String.format("| %s |"+RESET, NAVIO_USUARIO))) {
           this.addShoot(row, col, Computador.shootComputer);
           return true;
        }
        // Navio do computador
        else if (rowColInseridos.equals(
                String.format("| %s "+RESET,NAVIO_COMPUTADOR )) || rowColInseridos.equals(
                String.format("| %s |"+RESET, NAVIO_COMPUTADOR))) {
            this.addShoot(row, col, Usuario.shootUse);
            return true;
        }
        // Tiro na água
        else {
            this.addShootWater(row, col);
            return false;
        }
    }

    //FUNÇÃO EVITA TIROS REPETIDOS NA ÁGUA RETORNANDO FALSE
    public Boolean notRepeatAttack(int row, int col){
        String rowColInseridos = this.getStringMatrix(row,col);
        return !(rowColInseridos.equals(String.format("| %s ", WATER)) || rowColInseridos.equals(String.format("| %s |", WATER)));
    }

    //FUNÇÃO PARA NÃO REPETIR TIRO CERTO
    public Boolean notRepeatShootRight(int row,int col){
        String rowColInseridos  = this.getStringMatrix(row,col);
        return (rowColInseridos.equalsIgnoreCase(
                String.format("| %s ", Computador.shootComputer)) || rowColInseridos.equalsIgnoreCase(
                        String.format("| %s |", Computador.shootComputer)));
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
        System.out.printf(GREEN+"---------------------------------------------%n"+RESET);
        System.out.printf(GREEN+"                   JOGADOR                   %n"+RESET);
        System.out.printf(GREEN+"---------------------------------------------%n"+RESET);
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
        System.out.printf(RED+"---------------------------------------------%n"+RESET);
        System.out.printf(RED+"                  COMPUTADOR                 %n"+RESET);
        System.out.printf(RED+"---------------------------------------------%n"+RESET);
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
        matrizTabuleiro[row][col] = (col == 10)? String.format("| %s |"+RESET, NAVIO_USUARIO):String.format("| %s "+RESET,NAVIO_USUARIO);
    }

    public void addShipMatrixComputer(int row,int col){
        matrizTabuleiro[row][col] = (col == 10)? String.format("| %s |"+RESET, NAVIO_COMPUTADOR):String.format("| %s "+RESET,NAVIO_COMPUTADOR);
    }
}
