package batalha;

public class Jogo {
<<<<<<< HEAD
	
	
	
	public void jogarBombaNoComputador() {
		
	}
	
	public void jogarBombaNoUsuario() {
		
	}
	
	
=======


>>>>>>> a0d82e802b5ff292c40abcec5c91ff9f06505038
    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        Usuario usuario = new Usuario();
        
        
        tab.startMatrix();
        tab.showMatrix();
<<<<<<< HEAD
        usuario.posicionarNavios();
        
        
        
       // public void jogar(){
       // 	while ((user.points || computer.points) < 10){
       //		jogarBombaNoComputador()
       //       jogarBombaNoUsuario()
       // }
       // }
   
        
=======
        tab.addShipMatrix(1,3);
        tab.showMatrix();
>>>>>>> a0d82e802b5ff292c40abcec5c91ff9f06505038
    }
}
