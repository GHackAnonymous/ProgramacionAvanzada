import java.util.Random;

public class Arma extends Artefacto{
	Random rd;
	public Arma(int id, String nombre, int vidaQuita) {
		super(id, nombre, vidaQuita);
		rd = new Random();
	}
	@Override
	public int ataque(int capacidad) {
		int vidaQuita = 0;
		switch(capacidad){
		case 1:
			vidaQuita = super.getVidaQuita();
			break;
		case 0:
			boolean falla = rd.nextBoolean();
			if(falla == true){
				vidaQuita = 0;
			}else{
				vidaQuita = super.getVidaQuita();
			}
			break;
		default:
		}
		return vidaQuita;
	}	
}
