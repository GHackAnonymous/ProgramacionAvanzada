package ejercicioEmpresaAgroalimentaria;

public class Composicion {
	private int porNitrógeno;
	private int porOxígeno;
	private int porDióxidoCarbono;
	private int porVaporAgua;
	
	public Composicion(int porNitrógeno, int porOxígeno,
					int porDióxidoCarbono, int porVaporAgua){
		this.porNitrógeno = porNitrógeno;
		this.porOxígeno = porOxígeno;
		this.porDióxidoCarbono = porDióxidoCarbono;
		this.porVaporAgua = porVaporAgua;
	}
	public int getPorNitrógeno() {
		return porNitrógeno;
	}
	public void setPorNitrógeno(int porNitrógeno) {
		this.porNitrógeno = porNitrógeno;
	}
	public int getPorOxígeno() {
		return porOxígeno;
	}
	public void setPorOxígeno(int porOxígeno) {
		this.porOxígeno = porOxígeno;
	}
	public int getPorDióxidoCarbono() {
		return porDióxidoCarbono;
	}
	public void setPorDióxidoCarbono(int porDióxidoCarbono) {
		this.porDióxidoCarbono = porDióxidoCarbono;
	}
	public int getPorVaporAgua() {
		return porVaporAgua;
	}
	public void setPorVaporAgua(int porVaporAgua) {
		this.porVaporAgua = porVaporAgua;
	}
	@Override
	public String toString() {
		return "Porcentage de nitrogeno: "+this.porNitrógeno+"\n"+
				"Porcentage de Oxigeno: "+this.porOxígeno+"\n"+
				"Porcentage de Dioxide de carbono: "+this.porDióxidoCarbono+"\n"+
				"Porcentage de vapor de agua: "+this.porVaporAgua;
	}
}
