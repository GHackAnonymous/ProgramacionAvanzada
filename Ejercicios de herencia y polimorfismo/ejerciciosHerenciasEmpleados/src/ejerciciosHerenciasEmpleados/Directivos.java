package ejerciciosHerenciasEmpleados;

public class Directivos extends Empleado{
	
	private int productividad;
	
	public Directivos(int salario, String nombreApellido) {
		super(salario, nombreApellido);
	}

	public void addProductividad(int productividad){
		this.productividad = productividad;
	}
	@Override
	public String toString() {
		return super.toString()+"Salario: "+this.getSalario();
	}
	@Override
	public void salarioTener() {
		super.setSalario(super.getSalario() * (1+ this.productividad/100));
	}
}
