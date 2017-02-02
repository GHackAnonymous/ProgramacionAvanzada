package ejercicioEmpresaAgroalimentaria;

public class Composicion {
	private int porNitr�geno;
	private int porOx�geno;
	private int porDi�xidoCarbono;
	private int porVaporAgua;
	
	public Composicion(int porNitr�geno, int porOx�geno,
					int porDi�xidoCarbono, int porVaporAgua){
		this.porNitr�geno = porNitr�geno;
		this.porOx�geno = porOx�geno;
		this.porDi�xidoCarbono = porDi�xidoCarbono;
		this.porVaporAgua = porVaporAgua;
	}
	public int getPorNitr�geno() {
		return porNitr�geno;
	}
	public void setPorNitr�geno(int porNitr�geno) {
		this.porNitr�geno = porNitr�geno;
	}
	public int getPorOx�geno() {
		return porOx�geno;
	}
	public void setPorOx�geno(int porOx�geno) {
		this.porOx�geno = porOx�geno;
	}
	public int getPorDi�xidoCarbono() {
		return porDi�xidoCarbono;
	}
	public void setPorDi�xidoCarbono(int porDi�xidoCarbono) {
		this.porDi�xidoCarbono = porDi�xidoCarbono;
	}
	public int getPorVaporAgua() {
		return porVaporAgua;
	}
	public void setPorVaporAgua(int porVaporAgua) {
		this.porVaporAgua = porVaporAgua;
	}
	@Override
	public String toString() {
		return "Porcentage de nitrogeno: "+this.porNitr�geno+"\n"+
				"Porcentage de Oxigeno: "+this.porOx�geno+"\n"+
				"Porcentage de Dioxide de carbono: "+this.porDi�xidoCarbono+"\n"+
				"Porcentage de vapor de agua: "+this.porVaporAgua;
	}
}
