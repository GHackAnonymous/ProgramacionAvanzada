
public class Pocion extends Artefacto{

	public Pocion(int id, String nombre, int vidaQuita) {
		super(id, nombre, vidaQuita);
	}
	@Override
	public int darVida() {
		return super.getVidaQuita();
	}

}
