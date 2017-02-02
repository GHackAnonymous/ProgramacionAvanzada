public class Texto {
	
	Usuario usuario;
	String texto;

	public Texto (Usuario usuario, String texto){
		this.usuario = usuario;
		this.texto = texto;
	}

	@Override
	public String toString() {
		
		return usuario.getNombre()+": "+ texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getTexto() {
		return texto;
	}
}
