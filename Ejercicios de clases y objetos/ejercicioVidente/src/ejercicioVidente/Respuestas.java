package ejercicioVidente;

public class Respuestas {

	private final int CANTIDADRESPUESTAS = 10;
	private String[] respuestas;
	
	public Respuestas(){
		respuestas = new String[CANTIDADRESPUESTAS];
		rellenarRepuestas();
	}
	
	private void rellenarRepuestas(){
		respuestas[0] = "la fuerza contigo está";
		respuestas[1] = "malos presagios en el horizonte hay";
		respuestas[2] = "seguro que si";
		respuestas[3] = "no";
		respuestas[4] = "se presiente una gran desgracia";
		respuestas[5] = "eso no puede ser posible";
		respuestas[6] = "si";
		respuestas[7] = "no lo creo";
		respuestas[8] = "quizas";
		respuestas[9] = "no se que contestar";
	}
	
	public String obtenerRespuestas(int numeroRespuesta){
		return respuestas[numeroRespuesta];
	}
	
}
