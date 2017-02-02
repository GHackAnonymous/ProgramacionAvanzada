package ejercicioEmpresaAgroalimentaria;

import java.util.Date;

public class Agua extends Congelados{
	private int gramosPorLitrosSal;
	
	public Agua(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura, int gramosPorLitrosSal){
		super(nombre, fechaCaducidad, numeroLote, 
				fechaEnvasada, paisOrigen,
				temperatura);
		this.gramosPorLitrosSal = gramosPorLitrosSal;
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Salinidad del  agua: "+this.gramosPorLitrosSal+"g/l";
	}
	
}
