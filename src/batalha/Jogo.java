package batalha;

public class Jogo {
	
	
	
	public void jogarBombaNoComputador() {
		
	}
	
	
    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        Usuario usuario = new Usuario();
        
        
        tab.startMatrix();
        tab.showMatrix();
        usuario.posicionarNavios();
        
        
        
       // public void jogar(){
       // 	while ((user.points || computer.points) < 10){
       //		jogarBombaUser()
       //       jogarBombaComputer()
       // }
       // }
   
        
    }
}
