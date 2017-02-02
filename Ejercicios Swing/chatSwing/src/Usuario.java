public class Usuario {

	String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public Usuario (String nombre){
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Usuario){
			Usuario user = (Usuario) arg0;
			return user.nombre.equals(this.nombre);
		}
		return false;
	}
}
