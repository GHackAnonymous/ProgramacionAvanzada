package ejerciciosHerenciasEmpleados;

public class Normales extends Empleado{

	public Normales(int salario,String nombreApellido) {
		super(salario, nombreApellido);
	}
	@Override
	public String toString() {
		return super.toString()+"Salario: "+this.getSalario();
	}
	@Override
	public void salarioTener() {
		super.setSalario(super.getSalario());
	}
}
