package ejercicioEmpresaAgroalimentaria;

import java.util.Date;

public class Aire extends Congelados{
	private Composicion compuesto;
	
	public Aire(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura, int porNitr�geno, int porOx�geno,
			int porDi�xidoCarbono, int porVaporAgua){
		super(nombre, fechaCaducidad, numeroLote, 
				fechaEnvasada, paisOrigen,
				temperatura);
		this.compuesto = new Composicion(porNitr�geno, porOx�geno,
				porDi�xidoCarbono, porVaporAgua);
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Compuesto del aire -> \n"+this.compuesto.toString();
	}
	
}
