package batalha;

public class Jogo {


	public void jogarBombaNoComputador() {
		
	}
	
	public void jogarBombaNoUsuario() {

	}

    public Boolean validPositionShipComputer(int row,int col){
        return true;
    }

    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        
        Usuario igor = new Usuario(tab,0);
        
        
        tab.startMatrix();
        tab.showMatrix();
        
        igor.posicionarNavios();
    
       // public void jogar(){
       // 	while ((user.points || computer.points) < 10){
       //		jogarBombaNoComputador()
       //       jogarBombaNoUsuario()
       // }
       // }
    }
}
