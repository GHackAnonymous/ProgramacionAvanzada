package ejerciciosHerenciasEmpleados;

public abstract class Empleado {
	private String nombreApellido;
	private int salario;
	
	public Empleado(int salario,String nombreApellido){
		this.salario = salario;
		this.nombreApellido = nombreApellido;
	}
	
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Nombre: "+this.nombreApellido+"\n";
	}
	public abstract void salarioTener();
}
