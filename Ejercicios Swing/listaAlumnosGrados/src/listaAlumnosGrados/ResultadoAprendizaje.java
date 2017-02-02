package listaAlumnosGrados;

public class ResultadoAprendizaje {
	private String codigo;
	private String texto;
	private double nota;
	
	public ResultadoAprendizaje (String codigo, String texto){
		this.codigo = codigo;
		this.texto = texto;
		this.nota = 0.0;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTexto() {
		return texto;
	}
	@Override
	public String toString() {
		return codigo+":   "+nota;
	}
}
