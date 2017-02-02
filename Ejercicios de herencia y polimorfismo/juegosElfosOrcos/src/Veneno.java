
public class Veneno extends Artefacto{

	public Veneno(int id, String nombre, int vidaQuita) {
		super(id, nombre, vidaQuita);
	}
	@Override
	public int danoPorVeneno(){
		return super.getVidaQuita();
	}
}
