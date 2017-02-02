package ejercicioEmpresaAgroalimentaria;

import java.util.Date;

public class Aire extends Congelados{
	private Composicion compuesto;
	
	public Aire(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura, int porNitrógeno, int porOxígeno,
			int porDióxidoCarbono, int porVaporAgua){
		super(nombre, fechaCaducidad, numeroLote, 
				fechaEnvasada, paisOrigen,
				temperatura);
		this.compuesto = new Composicion(porNitrógeno, porOxígeno,
				porDióxidoCarbono, porVaporAgua);
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Compuesto del aire -> \n"+this.compuesto.toString();
	}
	
}
