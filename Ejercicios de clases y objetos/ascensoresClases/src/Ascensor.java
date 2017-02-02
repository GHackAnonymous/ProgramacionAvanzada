
public class Ascensor {
	private int id;
	private Puerta puerta;
	private int piso;
	
	public Ascensor(int id){
		this.id = id;
		puerta = new Puerta();
		piso = 0;
	}
	public boolean conprobarPuerta(){
		if(puerta.isPuertaAbierta() == true){
			puerta.setPuertaAbierta(false);
			return true;
		}else{
			return false;
		}
	}
	public boolean moverAscesor(int quePiso){
		piso = quePiso;
		puerta.setPuertaAbierta(true);
		return true;
	}
	public Puerta getPuerta() {
		return puerta;
	}
	public void setPuerta(Puerta puerta) {
		this.puerta = puerta;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getId() {
		return id;
	}
}
