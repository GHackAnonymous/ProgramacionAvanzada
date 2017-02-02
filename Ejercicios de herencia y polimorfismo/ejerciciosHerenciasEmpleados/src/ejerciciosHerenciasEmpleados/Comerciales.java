package ejerciciosHerenciasEmpleados;

public class Comerciales extends Empleado{

	private int ventas;
	
	public Comerciales(int salario, String nombreApellido) {
		super(salario, nombreApellido);
	}
	public void addVentas(int ventas){
		this.ventas = ventas;
	}
	@Override
	public String toString() {
		return super.toString()+"Salario: "+this.getSalario();
	}
	@Override
	public void salarioTener() {
		int numPorcent = this.ventas * 10 /100;
		super.setSalario(super.getSalario()+numPorcent);
	}

}
