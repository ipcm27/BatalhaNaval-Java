package batalha;

public class Jogo {


	public void jogarBombaNoComputador() {
		
	}
	
	public void jogarBombaNoUsuario() {

	}


    public static void main(String[] args) {
        Tabuleiro tabIgor = new Tabuleiro();
        Tabuleiro tabBer = new Tabuleiro();
        
        Usuario igor = new Usuario(tabIgor);
        Computador bernado = new Computador(tabBer);

        
        igor.posicionarNavios();
        bernado.generatorPositionShips(igor,tabBer);
        tabBer.showMatrix();


        //System.out.println(validPositionShipComputer(1,10,tab));//testando função

    
       // public void jogar(){
       // 	while ((user.points || computer.points) < 10){
       //		jogarBombaNoComputador()
       //       jogarBombaNoUsuario()
       // }
       // }
    }
}
